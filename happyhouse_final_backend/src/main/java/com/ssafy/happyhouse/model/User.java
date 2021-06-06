package com.ssafy.happyhouse.model;

public class User {
	private String user_name;
	private String user_password;
	private String user_id;
	private String user_sex;
	private int user_age;
	private String user_phone_number;
	private String user_email;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String setUser_age() {
		return user_phone_number;
	}
	public void setUser_phone_number(String user_phone_number) {
		this.user_phone_number = user_phone_number;
	}
	public String getUser_phone_number() {
		return user_phone_number;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public User() {
		
	}
	
	public User(String user_name, String user_password, String user_id, String user_sex, int user_age,
			String user_phone_number, String user_email) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_id = user_id;
		this.user_sex = user_sex;
		this.user_age = user_age;
		this.user_phone_number = user_phone_number;
		this.user_email = user_email;
	}
	
	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", user_password=" + user_password + ", user_id=" + user_id
				+ ", user_sex=" + user_sex + ", user_age=" + user_age + ", user_phone_number=" + user_phone_number
				+ ", user_email=" + user_email + "]";
	}
}
