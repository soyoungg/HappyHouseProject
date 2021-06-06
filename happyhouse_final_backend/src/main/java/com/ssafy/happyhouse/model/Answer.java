package com.ssafy.happyhouse.model;

public class Answer {
	private int answer_no;
	private int qna_no;
	private String answer_author;
	private String answer_date;
	private String answer_content;
	
	public int getAnswer_no() {
		return answer_no;
	}
	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getAnswer_author() {
		return answer_author;
	}
	public void setAnswer_author(String answer_author) {
		this.answer_author = answer_author;
	}
	public String getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	
	public Answer() {}
	
	public Answer(int answer_no, int qna_no, String answer_author, String answer_date, String answer_content) {
		super();
		this.answer_no = answer_no;
		this.qna_no = qna_no;
		this.answer_author = answer_author;
		this.answer_date = answer_date;
		this.answer_content = answer_content;
	}
	@Override
	public String toString() {
		return "Answer [answer_no=" + answer_no + ", qna_no=" + qna_no + ", answer_author=" + answer_author
				+ ", answer_date=" + answer_date + ", answer_content=" + answer_content + "]";
	}
	
}
