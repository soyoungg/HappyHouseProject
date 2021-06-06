package com.ssafy.happyhouse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.service.AnswerService;

@SpringBootTest
public class answerTest {
	@Autowired
	AnswerService ser;
//	@Test
//	void registAnswer() throws Exception {
//		System.out.println("===answer 등록=======");
//		Answer answer = new Answer(2, 1, "test","2020-05-23", "행복하세요");
//		int cnt = ser.writeAnswer(answer);
//		System.out.println(cnt);
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void modifyAnswer() throws Exception {
//		System.out.println("===answer 수정=======");
//		Answer answer = new Answer(1, 1, "이얍","2020-05-23", "행복하세요");
//		int cnt = ser.modifyAnswer(answer);
//		System.out.println(cnt);
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void listAnswer() throws Exception {
//		System.out.println("===answer 목록=======");
//		List<Answer> list= ser.listAnswer(1);
//		
//		for (Answer ans : list) {
//			System.out.println(ans);
//		}
//		System.out.println("=== 끝====");
//	}
	@Test
	void deleteAnswer() throws Exception {
		System.out.println("===answer 삭제=======");
		int cnt = ser.deleteAnswer(2);
		System.out.println(cnt);
		System.out.println("=== 끝====");
	}
}
