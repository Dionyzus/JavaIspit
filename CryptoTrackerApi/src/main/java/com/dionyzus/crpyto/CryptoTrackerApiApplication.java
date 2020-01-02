package com.dionyzus.crpyto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.dionyzus.crypto.client.PricesRestClient;
import com.dionyzus.crypto.restController.PricesCoinMarketCapRest;
import com.dionyzus.crypto.service.PriceService;

@Configuration
@EnableMongoRepositories("com.dionyzus.crypto.repository")
@EnableScheduling
@SpringBootApplication
public class CryptoTrackerApiApplication {

	@Value("${spring.data.mongodb.database}")
	private String mongoDB;

	public static void main(String[] args) {
		SpringApplication.run(CryptoTrackerApiApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public PricesRestClient pricesRestClient() {
		return new PricesRestClient();
	}
	@Bean
	public PricesCoinMarketCapRest pricesCoinMarketCapRest() {
		return new PricesCoinMarketCapRest();
	}
	@Bean
	public PriceService priceService() {
		return new PriceService();
	}


}

