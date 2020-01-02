package com.dionyzus.crypto.restController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dionyzus.crypto.entity.Prices;
import com.dionyzus.crypto.repository.PricesRepository;
import com.dionyzus.crypto.service.PriceService;

import okhttp3.ResponseBody;

@RestController
@RequestMapping("/query/prices/crypto")
public class PricesCoinMarketCapRest {
	
	@Autowired
	private PriceService priceService;
	@Autowired
	private PricesRepository priceRepository;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getPrices(@PathVariable String id){
		return ResponseEntity.ok(priceService.getInformation(id).getBody()); 
	}
	@GetMapping(value="exchange/{id}")
	public ResponseEntity<?> getInfo(@PathVariable String id) throws IOException{
		return ResponseEntity.ok(priceService.getExchangeInfo(id).toString()); 
	}
	@GetMapping(value="block")
	public ResponseEntity<?> getBlockInfo() throws IOException{
		return ResponseEntity.ok(priceService.getBlockMarketInfo().toString()); 
	}	
	@GetMapping(value="block/{id}")
	public ResponseEntity<?> getBlockInfo(@PathVariable String id) throws IOException{
		return ResponseEntity.ok(priceService.getBlockMarketInfo(id).toString()); 
	}	
	@GetMapping(value="paprika/{id}")
	public ResponseEntity<?> getPaprikaPrices(@PathVariable String id) throws IOException{
		return ResponseEntity.ok(priceService.getPaprikaInformation(id).toString()); 
	}	


	
	@RequestMapping(value="alert/{id}",method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> enableAlertPrices(@PathVariable String id, @RequestParam Double valueAlert, @RequestParam Boolean enableDisable){
		
		Prices price = new Prices();
		price.setId(id);
		price.setName(id);
		price.setPrice(valueAlert);
		price.setStatus(enableDisable);
		priceRepository.save(price);
		return ResponseEntity.ok(priceService.enableDisableAlert(id, valueAlert, enableDisable)); 
	}
}