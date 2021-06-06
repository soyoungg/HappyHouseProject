package com.ssafy.happyhouse.model;

public class Restaurant {
	private int restaurant_id;
	private String restaurant_name;
	private String restaurant_type;
	private String restaurant_address;
	
	public String getRestaurant_type() {
		return restaurant_type;
	}
	public void setRestaurant_type(String restaurant_type) {
		this.restaurant_type = restaurant_type;
	}

	
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public Restaurant() {
		
	}
	public Restaurant(int restaurant_id, String restaurant_name, String restaurant_type, String restaurant_address) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_type = restaurant_type;
		this.restaurant_address = restaurant_address;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name
				+ ", restaurant_type=" + restaurant_type + ", restaurant_address=" + restaurant_address + "]";
	}
}
