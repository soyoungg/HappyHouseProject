package com.ssafy.happyhouse.model;

public class Like {
	private String user_id;
	private int deal_no;
	
	
	public String getUser_id() {
		return user_id;
	}


	public void setUserid(String user_id) {
		this.user_id = user_id;
	}


	public int getDeal_no() {
		return deal_no;
	}


	public void setDeal_no(int deal_no) {
		this.deal_no = deal_no;
	}
	
	public Like() {
		
	}
	
	public Like(String user_id, int deal_no) {
		super();
		this.user_id = user_id;
		this.deal_no = deal_no;
	}


	@Override
	public String toString() {
		return "Like [user_id=" + user_id + ", deal_no=" + deal_no + "]";
	}
	
}
