package com.example.demo.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Property;
import com.example.demo.service.PropertyService;

@CrossOrigin
@RestController
public class PropertyRestController {

	@Autowired
	PropertyService propertyService;

	@PostMapping("/property")
	public ResponseEntity<Property> setProperty(@RequestBody Property property) {
		Property property1 = propertyService.setProperty(property);
		if (property1.getPropertyId() == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		} else {
			return ResponseEntity.of(Optional.of(property1));
		}
	}
	
	@GetMapping("/properties")
	public ResponseEntity<List<Property>> getProperty(){
		
		if(propertyService.getProperties()==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(propertyService.getProperties()));
		}
		
	}
	
	@GetMapping("/propertiesTypeSection")
	public ResponseEntity<List<Property>> getPropertyTypeSection(){
		List<Property> property=new ArrayList();
		boolean  flag;
		for(Property p:propertyService.getProperties()) {
		if(property.isEmpty()) {
			property.add(p);
		}else {
			flag = true;
			for(Property p2 : property) {
				if(p.getPropertyType().toLowerCase().equals(p2.getPropertyType().toLowerCase())) {
					flag = false;
					break;
				}
			}
			if(flag) {
				property.add(p);
			}
		}
			
		}
		if(property.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(property));
		}
	}
	
	@GetMapping("/properties/{type}")
	public ResponseEntity<List<Property>> getPropertyByType(@PathVariable String type){
		if(propertyService.getPropertiesByType(type)==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(propertyService.getPropertiesByType(type)));
		}
	}
	
	@GetMapping("/property/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable String id){
		if(propertyService.getPropertiesById(id).getPropertyId()==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(propertyService.getPropertiesById(id)));
		}
	}
	
	@GetMapping("/propertiesBestseller")
	public ResponseEntity<List<Property>> getPropertyByBestseller(@RequestParam boolean bestseller){
		if(propertyService.getPropertiesByBestseller(bestseller)==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(propertyService.getPropertiesByBestseller(bestseller)));
		}
		
	}
	
	@GetMapping("/property/title")
	public ResponseEntity<List<Property>> getPropertyByTitle( @RequestParam(defaultValue = "empty") String title, @RequestParam(defaultValue = "empty") String type){
		System.out.println("Type: "+ type +"  Title: " + title);
		if(propertyService.getPropertiesByTitle(title, type).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(propertyService.getPropertiesByTitle(title, type)));
		}
	}
	
	@PutMapping("property/update/{id}")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable String id){
		Property property1 = propertyService.updateProperty(property, id);
		if(property1.getPropertyId() == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
		return ResponseEntity.of(Optional.of(property1));
	}
	
	@DeleteMapping("property/delete/{id}")
	public ResponseEntity<String> deleteProperty(@PathVariable String id){
		String result = propertyService.deleteProperty(id);
		if(result.equals("not found")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(result));
		}
		
	}
}
