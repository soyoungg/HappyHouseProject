package com.ssafy.happyhouse.repo;

import java.util.List;

import com.ssafy.happyhouse.model.Answer;

public interface AnswerRepo {

	public int writeAnswer(Answer answer) throws Exception; 
	
	public int modifyAnswer(Answer answer) throws Exception; 
	
	public int deleteAnswer(int answer_no) throws Exception; 
	
//	public int getAnswerTotalCount(Map<String, String> map) throws Exception; 
	
	public List<Answer> listAnswer(int qna_no) throws Exception; 
	
}
