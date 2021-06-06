package com.ssafy.happyhouse;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.service.AdminDashboardService;

@SpringBootTest
public class admidashboardtest {
	@Autowired
	AdminDashboardService ser;
	
	@Test
	void user_sex() throws Exception {
		System.out.println("===성별 사용자 =======");
		
		List<Map<String, Integer>> list = ser.countByUserSex();
		for (Map<String, Integer> tmp : list) {
			System.out.println(tmp);
		}
		
		System.out.println("=== 끝====");
	}
//	@Test
//	void user_age() throws Exception {
//		System.out.println("===나이별 사용자 =======");
//		
//		List<Map<String, Integer>> list = ser.countByUserAge();
//		for (Map<String, Integer> tmp : list) {
//			System.out.println(tmp);
//		}
//		
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void user_region() throws Exception {
//		System.out.println("=== 사용자별 아파트 =======");
//		
//		List<Map<String, Integer>> list = ser.countApt();
//		for (Map<String, Integer> tmp : list) {
//			System.out.println(tmp);
//		}
//		
//		System.out.println("=== 끝====");
//	}
	
}
