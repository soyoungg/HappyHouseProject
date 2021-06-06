package com.ssafy.happyhouse.model;

public class QnA {
	private String qna_type;
	private int qna_no;
	private String qna_title;
	private String qna_author;
	private String qna_content;
	private String qna_date;
	
	public QnA() {
		
	}
	
	public QnA(String qna_type, int qna_no, String qna_title, String qna_author, String qna_content, String qna_date) {
		this.qna_type = qna_type;
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_author = qna_author;
		this.qna_content = qna_content;
		this.qna_date = qna_date;
	}
	
	
	public String getQna_type() {
		return qna_type;
	}
	public void setQna_type(String qna_type) {
		this.qna_type = qna_type;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_author() {
		return qna_author;
	}
	public void setQna_author(String qna_author) {
		this.qna_author = qna_author;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_date() {
		return qna_date;
	}
	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}
	@Override
	public String toString() {
		return "QnA [qna_type=" + qna_type + ", qna_no=" + qna_no + ", qna_title=" + qna_title + ", qna_author="
				+ qna_author + ", qna_content=" + qna_content + ", qna_date=" + qna_date + "]";
	}
	
	
}
