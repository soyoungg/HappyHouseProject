package com.ssafy.happyhouse;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.Park;
import com.ssafy.happyhouse.service.ParkService;


@SpringBootTest

public class parkTest {
	@Autowired
	ParkService ser;
	
//	@Test
//	void topPark() throws Exception {
//		System.out.println("===answer 등록=======");
//		
//		List<Map<String, Object>> list = ser.topPark();
//		for (Map<String, Object> tmp : list) {
//			System.out.println(tmp.get("addr"));
//
//			System.out.println(tmp.get("cnt"));
//		}
//		System.out.println("=== 끝====");
//	}
	
	@Test
	void listPark() throws Exception {
		System.out.println("===park 등록=======");
		List<Park> list = ser.listPark("충청북도 청주시 흥덕구");
		for (Park pa : list) {
			System.out.println(pa);
		}
		System.out.println("=== 끝====");
	}
}	
