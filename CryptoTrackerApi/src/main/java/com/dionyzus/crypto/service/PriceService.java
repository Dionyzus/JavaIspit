package com.dionyzus.crypto.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dionyzus.crypto.client.PricesRestClient;
import com.dionyzus.crypto.entity.Prices;
import com.dionyzus.crypto.repository.PricesRepository;
import com.dionyzus.crypto.utils.SendMail;

import okhttp3.ResponseBody;

import com.dionyzus.crypto.builder.output.EnableDisableAlertOutput;
import com.dionyzus.crypto.builder.output.PricesCryptoOutput;

@Service
public class PriceService {
	
	@Autowired
	private PricesRestClient pricesRestClient;
	
	@Autowired
	private PricesRepository pricesRepository;
	
	public ResponseEntity<PricesCryptoOutput[]> getInformation(String id) {
		return pricesRestClient.getCryptoInformation(id);
	}
	public String getExchangeInfo(String id) throws IOException {
		return pricesRestClient.GetExchangeRates(id);
	}
	public String getBlockMarketInfo(String id) throws IOException {
		return pricesRestClient.getBlockMarkets(id);
	}
	public String getBlockMarketInfo() throws IOException {
		return pricesRestClient.getBlockMarkets();
	}
	public String getPaprikaInformation(String id) throws IOException {
		return pricesRestClient.getCryptoInfoPaprika(id);
	}


	
	public String enableDisableAlert(String id, double alertPrice, boolean enableDisable) {
		Prices prices=pricesRepository.findByName(id);
		prices.setPrice(alertPrice);
		prices.setStatus(enableDisable);
		
		if(enableDisable)
			initMonitoringOfPrice(alertPrice, id);
		return new EnableDisableAlertOutput(enableDisable, new Date()).toString();
	}

	public String initMonitoringOfPrice(double alertPrice, String id) {
		System.out.println("===> Monitoring price <===");
		List<PricesCryptoOutput> info = Arrays.asList(pricesRestClient.getCryptoInformation(id).getBody());
		info.forEach(item->{
			if(Double.parseDouble(item.getPrice_usd()) > alertPrice) {
				alertUser(Double.parseDouble(item.getPrice_usd()), id);
			}
		});
		return info.toString();
	}

	private void alertUser(double alertPrice, String id) {
		System.out.println("New price of "+id+" is "+alertPrice);
		SendMail.sendMail(alertPrice);
	}
}