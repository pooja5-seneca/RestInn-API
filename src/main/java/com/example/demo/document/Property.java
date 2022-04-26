package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Property")
public class Property {
	
	
	
	@Id
	private String propertyId;
	private String propertyImg;
	private String propertyTitle;
	private String propertyDesc;
	private String propertyPrice;
	PropertyLocation propertyLocation;
	private String propertyType;
	private String propertyRules;
	private String propertyAmenities;
	private boolean bestseller;
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(String propertyId, String propertyImg, String propertyTitle, String propertyDesc,
			String propertyPrice, PropertyLocation propertyLocation, String propertyType, String propertyRules,
			String propertyAmenities, boolean bestseller) {
		super();
		this.propertyId = propertyId;
		this.propertyImg = propertyImg;
		this.propertyTitle = propertyTitle;
		this.propertyDesc = propertyDesc;
		this.propertyPrice = propertyPrice;
		this.propertyLocation = propertyLocation;
		this.propertyType = propertyType;
		this.propertyRules = propertyRules;
		this.propertyAmenities = propertyAmenities;
		this.bestseller = bestseller;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyImg() {
		return propertyImg;
	}

	public void setPropertyImg(String propertyImg) {
		this.propertyImg = propertyImg;
	}

	public String getPropertyTitle() {
		return propertyTitle;
	}

	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}

	public String getPropertyDesc() {
		return propertyDesc;
	}

	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}

	public String getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(String propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public PropertyLocation getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(PropertyLocation propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyRules() {
		return propertyRules;
	}

	public void setPropertyRules(String propertyRules) {
		this.propertyRules = propertyRules;
	}

	public String getPropertyAmenities() {
		return propertyAmenities;
	}

	public void setPropertyAmenities(String propertyAmenities) {
		this.propertyAmenities = propertyAmenities;
	}

	public boolean getBestseller() {
		return bestseller;
	}

	public void setBestseller(boolean bestseller) {
		this.bestseller = bestseller;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyImg=" + propertyImg + ", propertyTitle="
				+ propertyTitle + ", propertyDesc=" + propertyDesc + ", propertyPrice=" + propertyPrice
				+ ", propertyLocation=" + propertyLocation + ", propertyType=" + propertyType + ", propertyRules="
				+ propertyRules + ", propertyAmenities=" + propertyAmenities + ", bestseller=" + bestseller + "]";
	}

	
}
