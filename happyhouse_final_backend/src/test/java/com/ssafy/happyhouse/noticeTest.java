package com.ssafy.happyhouse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.Notice;
import com.ssafy.happyhouse.service.NoticeService;


@SpringBootTest
public class noticeTest {
	
	@Autowired
	NoticeService ser;
	
//	@Test
//	void registNotice() throws Exception {
//		System.out.println("=======공지 등록=======");
//		Notice notice = new Notice("문의", 1, "noticetest", "test", "test", "2020-05-23");
//		int sys = ser.writeNotice(notice);
//		System.out.println(sys);
//		System.out.println("=== 끝====");
//	}
	
//	@Test 
//	void modifyNotice() throws Exception {
//		System.out.println("=======공지 수정=======");
//		Notice notice = new Notice("공지", 1, "noticetest", "test", "test", "2020-05-23");
//		int sys = ser.modifyNotice(notice);
//		System.out.println(sys);
//	}
	
//	@Test 
//	void getNotice() throws Exception {
//		System.out.println("=======공지 상세보기=======");
//		Notice notice = ser.getNotice(1);
//		System.out.println(notice);
//	}
	
//	@Test 
//	void listNotice() throws Exception {
//		System.out.println("=======공지 목록=======");
//		List<Notice> list = ser.listNotice();
//		for (Notice notice : list) {
//			System.out.println(notice);
//		}
//	}

	@Test 
	void deleteNotice() throws Exception {
		System.out.println("=======공지 삭제=======");
		int cnt = ser.deleteNotice(1);
		System.out.println(cnt);
	}
}
