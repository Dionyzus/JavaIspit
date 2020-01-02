package com.dionyzus.crpytoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.dionyzus.crpytoClient.clientService.RestClientService;
import com.dionyzus.crpytoClient.controller.PricesCryptoOutputController;
import com.dionyzus.cryptoClient.ClientRepo.RoleRepository;
import com.dionyzus.cryptoClient.domain.Role;

@Configuration
@EnableMongoRepositories("com.dionyzus.cryptoClient.ClientRepo")
@SpringBootApplication
@EnableScheduling
public class CryptoTrackerClientApplication {
	
	@Value("${spring.data.mongodb.database}")
	private String mongoDB;

	public static void main(String[] args) {
		SpringApplication.run(CryptoTrackerClientApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {

		return args -> {

			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if (userRole == null) {
				Role newUserRole = new Role();
				newUserRole.setRole("USER");
				roleRepository.save(newUserRole);
			}
		};

	}

	// defining a RestTemplate Bean to make it available to the application context
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RestClientService restClientService(RestTemplate restTemplate) {
		return new RestClientService(restTemplate);
	}

	@Bean
	public PricesCryptoOutputController pricesCryptoOutputController(RestClientService service) {
		return new PricesCryptoOutputController(service);
	}


}
