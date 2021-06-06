package com.ssafy.happyhouse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.QnA;
import com.ssafy.happyhouse.service.QnAService;


@SpringBootTest
public class qnaTest {
	
	@Autowired
	QnAService ser;
	
//	@Test
//	void registQnA() throws Exception {
//		System.out.println("===QnA 등록=======");
//		QnA qna = new QnA("문의", 1, "qnatest", "test", "test", "2020-05-23");
//		int sys = ser.writeQnA(qna);
//		System.out.println(sys);
//		System.out.println("=== 끝====");
//	}
	
//	@Test
//	void modifyQnA() throws Exception {
//		System.out.println("===QnA 수정=======");
//		QnA qna = new QnA("신고", 1, "qnatest", "test", "test", "2020-05-23");
//		int sys = ser.modifyQnA(qna);
//		System.out.println(sys);
//		System.out.println("=== 끝====");
//	}
	
//	@Test
//	void getQnA() throws Exception {
//		System.out.println("===QnA 상세보기=======");
//		QnA qna = ser.getQnA(1);
//		System.out.println(qna);
//		System.out.println("=== 끝====");
//	}
	
//	@Test
//	void listQnA() throws Exception {
//		System.out.println("===QnA 목록=======");
//		List<QnA> qna = ser.listQnA();
//		for (QnA list : qna) {
//			System.out.println(list);
//			
//		}
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void deleteQnA() throws Exception {
//		System.out.println("===QnA 삭제=======");
//		int cnt = ser.deleteQnA(2);
//		System.out.println(cnt);
//		System.out.println("=== 끝====");
//	}
	
	
}
