package com.dionyzus.crpytoClient.clientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dionyzus.crpytoClient.model.PricesCryptoOutput;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

//set up the class as a service
@Service
public class RestClientService {

	// define a RestTemplate object
	private final RestTemplate restTemplate;

	// web service resources endpoints
	private final String GET_URL_BY_ID = "http://localhost:8085/api/query/prices/crypto/";
	private final String GET_EXCH_BY_ID = "http://localhost:8085/api/query/prices/crypto/exchange/";
	private final String GET_PAPRIKA_BY_ID = "http://localhost:8085/api/query/prices/crypto/paprika/";
	private final String GET_PAIRS = "http://localhost:8085/api/query/prices/crypto/block/";
	private final String GET_PAIRS_BY_ID = "http://localhost:8085/api/query/prices/crypto/block/";
	private final String POST_SEND_EMAIL="http://localhost:8085/api/query/prices/crypto/alert/";

	// define an argument constructor, pass in the RestTemplate object
	// and Autowire it
	@Autowired
	public RestClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Get a PricesCryptoOutput by id
	 * 
	 * @param id of PricesCryptoOutput
	 * @return a PricesCryptoOutput
	 */
	public PricesCryptoOutput[] findByID(String id) {
		return restTemplate.getForObject(GET_URL_BY_ID + id, PricesCryptoOutput[].class);
	}
	/**
	 * Get a String of exch by id
	 * 
	 * @param id of cryptoValue
	 * @return a String
	 */
	public String findExchByID(String id) {
		return restTemplate.getForObject(GET_EXCH_BY_ID + id, String.class);
	}
	/**
	 * Get a String of paprika by id
	 * 
	 * @param id of paprikaCrypto
	 * @return a String
	 */
	public String findPaprikaByID(String id) {
		return restTemplate.getForObject(GET_PAPRIKA_BY_ID + id, String.class);
	}
	public String informUser(String id) {
	
		return restTemplate.getForObject(POST_SEND_EMAIL + id, String.class);
	}
	public String findAllPairs()
	{
		return restTemplate.getForObject(GET_PAIRS ,String.class);
	}
	public String findPairByID(String id)
	{
		return restTemplate.getForObject(GET_PAIRS_BY_ID + id, String.class);
	}
	
}