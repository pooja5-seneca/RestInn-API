package com.example.demo.document;

import org.springframework.beans.factory.annotation.Autowired;

public class PropertyLocation {
	
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zip;
	
	public PropertyLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public PropertyLocation(String streetAddress, String city, String state, String country, String zip) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "PropertyLocation [streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip=" + zip + "]";
	}

}
