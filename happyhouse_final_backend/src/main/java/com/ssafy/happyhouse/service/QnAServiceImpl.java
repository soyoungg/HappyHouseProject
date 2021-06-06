package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.model.QnA;
import com.ssafy.happyhouse.repo.QnARepo;
import com.ssafy.util.PageNavigation;
@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
	QnARepo repo;
	
	
	@Override
	public int writeQnA(QnA qna) throws Exception {
		return repo.writeQnA(qna);
	}

	@Override
	public QnA getQnA(int qna_no) throws Exception {
		// TODO Auto-generated method stub
		return repo.getQnA(qna_no);
	}

	@Override
	public int deleteQnA(int qna_no) throws Exception {
		return repo.deleteQnA(qna_no);
	}

	@Override
	public int modifyQnA(QnA qna, QnA origin) throws Exception {
		if(qna.getQna_title() == null) {
			qna.setQna_title(origin.getQna_title());
		}else if(qna.getQna_type() == null) {
			qna.setQna_type(origin.getQna_type());
		}else if(qna.getQna_content() == null) {
			qna.setQna_content(origin.getQna_content());
		}
		return repo.modifyQnA(qna);
	}

//	@Override
//	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<QnA> listQnA() throws Exception {
		// TODO Auto-generated method stub
		return repo.listQnA();
	}

	@Override
	public List<QnA> listQnAwp(int offset, int limit) throws Exception {
		// TODO Auto-generated method stub
		return repo.listQnAwp(offset, limit);
	}

}
