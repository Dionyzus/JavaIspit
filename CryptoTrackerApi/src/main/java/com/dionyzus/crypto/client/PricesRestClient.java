package com.dionyzus.crypto.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dionyzus.crypto.builder.output.PricesCryptoOutput;
import com.dionyzus.crypto.cryptCompare.RawData;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;



@Component
public class PricesRestClient {
	
	@Autowired
    private RestTemplate restTemplate;

	public ResponseEntity<PricesCryptoOutput[]> getCryptoInformation(String id) {
		System.out.println("API CoinMarketCap");
		return restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/"+id, PricesCryptoOutput[].class);
	}
	public String GetExchangeRates(String id) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("https://rest.coinapi.io/v1/exchangerate/"+ id)
		  .addHeader("X-CoinAPI-Key", "15237629-2371-472C-B272-B0760C65FCC5")
		  .build();

		Response response = client.newCall(request).execute();

		return response.body().string();
	}
	public String getBlockMarkets(String id) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("https://api.blockmarkets.io/v1/pairs/"+ id)
		  .addHeader("X-api-key", "b8wAgFT27RUH0wieeE4f8qNStc2E0YQ1Jp0mQoVg")
		  .build();

		Response response = client.newCall(request).execute();

		return response.body().string();
	}
	public String getBlockMarkets() throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("https://api.blockmarkets.io/v1/pairs/")
		  .addHeader("X-api-key", "b8wAgFT27RUH0wieeE4f8qNStc2E0YQ1Jp0mQoVg")
		  .build();

		Response response = client.newCall(request).execute();

		return response.body().string();
	}
	public String getCryptoInfoPaprika(String id) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("https://api.coinpaprika.com/v1/tickers/"+ id)
		  .build();

		Response response = client.newCall(request).execute();

		return response.body().string();
	}
	
	
}