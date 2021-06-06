package com.ssafy.happyhouse.model;

public class Park {
	private int park_id;
	private String park_name;
	private String park_address;
	private String latitude;
	private String longtitude;
	
	public int getPark_id() {
		return park_id;
	}
	public void setPark_id(int park_id) {
		this.park_id = park_id;
	}
	public String getPark_name() {
		return park_name;
	}
	public void setPark_name(String park_name) {
		this.park_name = park_name;
	}
	public String getPark_address() {
		return park_address;
	}
	public void setPark_address(String park_address) {
		this.park_address = park_address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	
	public Park() {
		
	}
	
	public Park(int park_id, String park_name, String park_address, String latitude, String longtitude) {
		super();
		this.park_id = park_id;
		this.park_name = park_name;
		this.park_address = park_address;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	
	@Override
	public String toString() {
		return "Park [park_id=" + park_id + ", park_name=" + park_name + ", park_address=" + park_address
				+ ", latitude=" + latitude + ", longtitude=" + longtitude + "]";
	}
	
}
