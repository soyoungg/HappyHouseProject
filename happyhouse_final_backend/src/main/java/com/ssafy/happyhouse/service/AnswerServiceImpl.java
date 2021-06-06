package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.repo.AnswerRepo;
@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerRepo repo;
	@Override
	public int writeAnswer(Answer answer) throws Exception {
		return repo.writeAnswer(answer);
	}

	@Override
	public int modifyAnswer(Answer answer) throws Exception {
		// TODO Auto-generated method stub
		return repo.modifyAnswer(answer);
	}

	@Override
	public int deleteAnswer(int answer_no) throws Exception {
		// TODO Auto-generated method stub
		return repo.deleteAnswer(answer_no);
	}

	@Override
	public List<Answer> listAnswer(int qna_no) throws Exception {
		// TODO Auto-generated method stub
		return repo.listAnswer(qna_no);
	}

}
