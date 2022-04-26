package com.example.demo.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.Property;

@Repository
public interface PropertyDetails extends MongoRepository<Property, String> {
	
	public List<Property> findByPropertyType(String propertyType);
	//public List<Property> findByPropertyTitle(String propertyTitle, String propertyType);
	public List<Property> findByPropertyTitle(String propertyTitle);
	public List<Property> findByBestseller(boolean bestseller);

}
