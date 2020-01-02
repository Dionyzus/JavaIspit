package com.dionyzus.crpytoClient.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dionyzus.crpytoClient.clientService.RestClientService;
import com.dionyzus.crpytoClient.model.Base;
import com.dionyzus.crpytoClient.model.CryptoBase;
import com.dionyzus.crpytoClient.model.CryptoPaprika;
import com.dionyzus.crpytoClient.model.Datum;
import com.dionyzus.crpytoClient.model.Example;
import com.dionyzus.crpytoClient.model.Market;
import com.dionyzus.crpytoClient.model.PricesCryptoOutput;
import com.dionyzus.crpytoClient.model.Rate;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Controller
public class PricesCryptoOutputController {
	
	private final String POST_SEND_EMAIL="http://localhost:8085/api/query/prices/crypto/alert/";
	

	// define a service constant
	private final RestClientService service;

	// Argument contructor of controller, pass in the service
	// and Autowire it
	@Autowired
	public PricesCryptoOutputController(RestClientService service) {
		this.service = service;
	}

	/**
	 * Get a PricesCryptoOutput by id
	 * 
	 * @param id    of PricesCryptoOutput
	 * @param model binding a PricesCryptoOutput to view
	 * @return a crypto-info page
	 * @throws IOException
	 */
	@GetMapping("/crypto/{id}")
	public String getById(@PathVariable String id, Model model) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String cryptoInfo = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(service.findByID(id));

		StringBuilder sb = new StringBuilder(cryptoInfo);
		sb.replace(0, 2, "");
		sb.replace(sb.length() - 2, sb.length(), "");
		cryptoInfo = sb.toString();

		PricesCryptoOutput info = objectMapper.readValue(cryptoInfo, PricesCryptoOutput.class);

		String temp = info.getLast_updated();
		Double value= Double.parseDouble(info.getPrice_usd()) + 100;
		
		
		long durationInMillis = Long.parseLong(temp);
		java.util.Date time = new java.util.Date((long) durationInMillis * 1000);

		model.addAttribute("value",value);
		model.addAttribute("time", time);
		model.addAttribute("crypto", info);
		return "crypto-info";
	}

	/**
	 * Get a cryptoExch by id
	 * 
	 * @param id    of cryptoValue
	 * @param model binding a String to view
	 * @return a crypto-exch page
	 * @throws IOException
	 */
	@GetMapping("/rates/{id}")
	public String getExchById(@PathVariable String id, Model model) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String fullInfo = service.findExchByID(id);

		//String jsonTest = "{\"asset_id_base\": \"BTC\",\"rates\" : [{\"time\": \"2017-08-09T14:31:37.0520000Z\",\"asset_id_quote\": \"USD\",\"rate\": 3258.8875417798037784035133948},{\"time\": \"2017-08-09T14:31:36.7570000Z\", \"asset_id_quote\": \"EUR\",\"rate\": 2782.5255080599273092901331567 }]}";

		CryptoBase exchObj = objectMapper.readValue(fullInfo, CryptoBase.class);

		model.addAttribute("crypto", exchObj);
		return "crypto-exch";
	}
	@GetMapping("/paprika/{id}")
	public String getPaprikaById(@PathVariable String id, Model model) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String fullInfo = service.findPaprikaByID(id);

		CryptoPaprika paprikaInfo = objectMapper.readValue(fullInfo, CryptoPaprika.class);

		//String cryptoInfo = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(paprikaInfo);

	
		model.addAttribute("paprika", paprikaInfo);

		return "crypto-paprika";
	}
	@GetMapping("/block")
	public String getPairs(Model model) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String pair = service.findAllPairs();

		Example base = objectMapper.readValue(pair, Example.class);

		//String cryptoInfo = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(base);
		

		model.addAttribute("base", base);

		return "crypto-block";
	}
	@GetMapping("/block/{id}")
	public String getPairsById(@PathVariable String id, Model model) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String pair = service.findPairByID(id);

		Example base = objectMapper.readValue(pair, Example.class);

		//String cryptoInfo = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(base);
		
		List<Market> markets = null;
		List<Datum> datum=base.getData();
		for (Datum temp : datum) {
			markets=temp.getMarkets();
		}


		model.addAttribute("markets",markets);
		model.addAttribute("base", base);

		return "crypto-block-pair";
	}
	
	@RequestMapping("/profile")
	public String sendInfoToUser(Model model) throws IOException
	{
		return "dashboard";
	}
	
	
}
