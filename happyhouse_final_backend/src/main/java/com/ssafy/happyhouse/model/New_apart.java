package com.ssafy.happyhouse.model;

public class New_apart {
	
	private int idx;
	private String apart_name;
	private int price;
	private String floor;
	private String area;
	private String build_year;
	private String zip_code;
	
	private String city;
	private String gungu;
	private String dong;
	private String jibun;
	
	
	@Override
	public String toString() {
		return "New_apart [idx=" + idx + ", apart_name=" + apart_name + ", price=" + price + ", floor=" + floor
				+ ", area=" + area + ", build_year=" + build_year + ", zip_code=" + zip_code + ", city=" + city
				+ ", gungu=" + gungu + ", dong=" + dong + ", jibun=" + jibun + "]";
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGungu() {
		return gungu;
	}
	public void setGungu(String gungu) {
		this.gungu = gungu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	
	
	
	
	
}
