package com.ssafy.happyhouse.model;

public class New_apt_register {

	
	public String getApart_name() {
		return apart_name;
	}
	public void setApart_name(String apart_name) {
		this.apart_name = apart_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBuild_year() {
		return build_year;
	}
	public void setBuild_year(String build_year) {
		this.build_year = build_year;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	private String apart_name;
	private int price;
	private String floor;
	private String area;
	private String build_year;
	private String zip_code;
	
	public New_apt_register() {}

	public New_apt_register(String apart_name,int price, String floor, String area, String build_year, String zip_code) {
		this.apart_name = apart_name;
		this.price = price;
		this.floor = floor;
		this.area = area;
		this.build_year = build_year;
		this.zip_code = zip_code;
	}

	
}
