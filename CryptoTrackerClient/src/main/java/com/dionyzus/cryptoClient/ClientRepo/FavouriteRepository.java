package com.dionyzus.cryptoClient.ClientRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dionyzus.cryptoClient.domain.Favourite;



public interface FavouriteRepository extends MongoRepository<Favourite, String> {
    
   
    
}