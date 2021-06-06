package com.ssafy.happyhouse.model;

public class viewApartInt {
	private String aptname;
	private String date;
	private int dealamount;
	private int buildyear;
	private String area;
	private int floor;
	
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	
	public int getBuildyear() {
		return buildyear;
	}
	public void setBuildyear(int buildyear) {
		this.buildyear = buildyear;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getDealamount() {
		return dealamount;
	}
	public void setDealamount(int dealamount) {
		this.dealamount = dealamount;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public viewApartInt() {}
	@Override
	public String toString() {
		return "viewApartInt [aptname=" + aptname + ", date=" + date + ", dealamount=" + dealamount + ", buildyear="
				+ buildyear + ", area=" + area + ", floor=" + floor + "]";
	}
	public viewApartInt(String aptname, String date, int dealamount, int buildyear, String area, int floor) {
		super();
		this.aptname = aptname;
		this.date = date;
		this.dealamount = dealamount;
		this.buildyear = buildyear;
		this.area = area;
		this.floor = floor;
	}
	
	
	

}