package com.ssafy.happyhouse.model;

public class viewApart {
	private String aptname;
	private int dealyear;
	private int dealmonth;
	private int dealday;
	private String dealamount;
	private int buildyear;
	private String area;
	private int floor;
	
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public int getDealyear() {
		return dealyear;
	}
	public void setDealyear(int dealyear) {
		this.dealyear = dealyear;
	}
	public int getDealmonth() {
		return dealmonth;
	}
	public void setDealmonth(int dealmonth) {
		this.dealmonth = dealmonth;
	}
	public int getDealday() {
		return dealday;
	}
	public void setDealday(int dealday) {
		this.dealday = dealday;
	}
	public String getDealamount() {
		return dealamount;
	}
	public void setDealamount(String dealamount) {
		this.dealamount = dealamount;
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
	
	public viewApart() {}
	public viewApart(String aptname, int dealyear, int dealmonth, int dealday, String dealamount, int buildyear,
			String area, int floor) {
		super();
		this.aptname = aptname;
		this.dealyear = dealyear;
		this.dealmonth = dealmonth;
		this.dealday = dealday;
		this.dealamount = dealamount;
		this.buildyear = buildyear;
		this.area = area;
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "viewApart [aptname=" + aptname + ", dealyear=" + dealyear + ", dealmonth=" + dealmonth + ", dealday="
				+ dealday + ", dealamount=" + dealamount + ", buildyear=" + buildyear + ", area=" + area + ", floor="
				+ floor + "]";
	}
	
}
