package com.dionyzus.crypto.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.dionyzus.crypto.entity.Prices;



public interface PricesRepository extends MongoRepository<Prices, String> {
	 Prices findByName(String name);
	 
}