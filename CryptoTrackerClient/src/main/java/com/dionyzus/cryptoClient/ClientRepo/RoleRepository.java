package com.dionyzus.cryptoClient.ClientRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dionyzus.cryptoClient.domain.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
}