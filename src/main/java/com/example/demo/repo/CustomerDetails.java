package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.Customer;

@Repository
public interface CustomerDetails extends MongoRepository<Customer, String>{
	
	public Optional<Customer> findByEmail(String email);
	

}
