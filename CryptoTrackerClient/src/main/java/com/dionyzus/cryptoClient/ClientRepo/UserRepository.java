package com.dionyzus.cryptoClient.ClientRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dionyzus.cryptoClient.domain.User;


public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email);
    
    
}