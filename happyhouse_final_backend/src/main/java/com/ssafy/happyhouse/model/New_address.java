package com.ssafy.happyhouse.model;

public class New_address {
	
	private String zip_code;
	private String city;
	private String gungu;
	private String dong;
	private String jibun;
	@Override
	public String toString() {
		return "New_address [zip_code=" + zip_code + ", city=" + city + ", gungu=" + gungu + ", dong=" + dong
				+ ", jibun=" + jibun + "]";
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
