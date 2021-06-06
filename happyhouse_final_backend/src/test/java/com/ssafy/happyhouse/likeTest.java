package com.ssafy.happyhouse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.service.AnswerService;
import com.ssafy.happyhouse.service.FavoriteService;

@SpringBootTest
public class likeTest {
	@Autowired
	FavoriteService ser;
	
//	@Test
//	void registAnswer() throws Exception {
//		System.out.println("===like 등록=======");
//		Like like = new Like("test1", 1);
//		int cnt = ser.registLike(like);
//		Like like1 = new Like("test1", 2);
//		int cnt1 = ser.registLike(like1);
//		Like like2 = new Like("test1", 3);
//		int cnt2 = ser.registLike(like2);
//		Like like3 = new Like("test1", 4);
//		int cnt3 = ser.registLike(like3);
//		Like like4 = new Like("test2", 4);
//		int cnt4 = ser.registLike(like4);
//		
//		
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void deleteAnswer() throws Exception {
//		System.out.println("===like 삭제=======");
//		Like like2 = new Like("test1", 3);
//		int cnt2 = ser.deleteLike(like2);
//		System.out.println(cnt2);
//		
//		System.out.println("=== 끝====");
//	}
	

	@Test
	void listAnswer() throws Exception {
		System.out.println("===like 목록=======");
		
		List<String> list = ser.listLike("test1");
		for (String fv : list) {
			System.out.println(fv);
		}
		
		System.out.println("=== 끝====");
	}
	
}
