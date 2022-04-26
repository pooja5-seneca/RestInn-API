package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.document.Hotel;
import com.example.demo.repo.HotelDetails;

@Service
public class HotelService {

	@Autowired
	HotelDetails hRepo;

	public Hotel setHotelDetails(Hotel hotel) {
		return hRepo.save(hotel);
	}

	public List<Hotel> getAllHotelDetails() {
		return hRepo.findAll();
	}

	public Hotel getHotelDetails(String id) {
		// return hRepo.findById(id);
		Optional<Hotel> hotel = hRepo.findById(id);
		if (hotel.isPresent()) {
			return hotel.get();
		} else {
			return new Hotel();
		}
	}

	public Hotel updateHotelDetails(Hotel hotel) {
		return hRepo.save(hotel);
	}

	public String deleteHoteDetails(String id) {
		if (hRepo.findById(id).isPresent()) {
			hRepo.deleteById(id);
			return "Hotel deleted";
		} else {

			return "Product Does not exist";
		}
	}
}
