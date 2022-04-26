package com.example.demo.RestController;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Hotel;
import com.example.demo.service.HotelService;

@RestController
public class HotelRestController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/hotels")
	public List<Hotel> getAllHotelDetails(){
		return hotelService.getAllHotelDetails();
	}
	
	@PostMapping("/hotels")
	public Hotel setHotelDetails(@RequestBody Hotel hotel) {
		return hotelService.setHotelDetails(hotel);
	}
	
	@GetMapping("/hotels/{id}")
	public Hotel getHotelDetails(@PathVariable String id){
		return hotelService.getHotelDetails(id);
	}
	
	@PutMapping("/hotels/{id}")
	public Hotel updateHotelDetails(@RequestBody Hotel hotel, @PathVariable String id){
		hotel.setId(id);
		return hotelService.updateHotelDetails(hotel);
	}
	
	@DeleteMapping("/hotels/{id}")
	public String deleteHoteDetails( @PathVariable String id){
		return hotelService.deleteHoteDetails(id);
	}
}
