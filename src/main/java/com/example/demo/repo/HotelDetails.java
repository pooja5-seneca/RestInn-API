package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.Hotel;

@Repository
public interface HotelDetails extends MongoRepository<Hotel, String> {
	

}
