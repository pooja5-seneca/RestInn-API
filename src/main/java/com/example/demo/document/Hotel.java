package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Hotel")
public class Hotel {
	@Id
	private String id;
	private String name;
	private String img;
	private String description;
	
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hotel(String id, String name, String img, String description) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.description = description;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", img=" + img + ", description=" + description + "]";
	}

}
