package com.ssafy.happyhouse.model;

public class Notice {
	private String notice_type;
	private int notice_no;
	private String notice_title;
	private String notice_author;
	private String notice_content;
	private String notice_date;
	
	public String getNotice_type() {
		return notice_type;
	}
	public void setNotice_type(String notice_type) {
		this.notice_type = notice_type;
	}
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_author() {
		return notice_author;
	}
	public void setNotice_author(String notice_author) {
		this.notice_author = notice_author;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	
	public Notice() {
		
	}
	
	public Notice(String notice_type, int notice_no, String notice_title, String notice_author, String notice_content,
			String notice_date) {
		super();
		this.notice_type = notice_type;
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_author = notice_author;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
	}
	
	@Override
	public String toString() {
		return "Notice [notice_type=" + notice_type + ", notice_no=" + notice_no + ", notice_title=" + notice_title
				+ ", notice_author=" + notice_author + ", notice_content=" + notice_content + ", notice_date="
				+ notice_date + "]";
	}
	
	
	
}
