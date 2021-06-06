package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.model.QnA;
import com.ssafy.util.PageNavigation;

public interface QnAService {
		// QnA 추가
		public int writeQnA(QnA qna) throws Exception;
		
		// QnA 세부 읽기
		public QnA getQnA(int qna_no) throws Exception;
		
		// QnA 삭제
		public int deleteQnA(int qna_no) throws Exception;
		
		// QnA 수정
		public int modifyQnA(QnA qna, QnA origin) throws Exception;
		
		public List<QnA> listQnA()  throws Exception;
		
		public List<QnA> listQnAwp(int offset, int limit)  throws Exception;
}
