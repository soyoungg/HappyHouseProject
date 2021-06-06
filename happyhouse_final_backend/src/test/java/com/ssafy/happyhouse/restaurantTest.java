package com.ssafy.happyhouse;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.Restaurant;
import com.ssafy.happyhouse.service.RestaurantService;


@SpringBootTest
public class restaurantTest {
	
	@Autowired
	RestaurantService ser;
	
//	@Test
//	void top5addr() throws Exception {
//		System.out.println("=======top5 레스토랑=======");
//		List<Map<String, Object>> list = ser.topRestaurant();
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//			System.out.println(list.get(i).get("cnt"));
//		}
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void top5Cnt() throws Exception {
//		System.out.println("=======top5 레스토랑=======");
//		List<Map<String, Integer>> list = ser.topRestaurantCnt();
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("=== 끝====");
//	}
	
	@Test
	void selectregion() throws Exception {
		System.out.println("=======레스토랑 리스트=======");
		List<Restaurant> list = ser.listRestaurant("서울특별시 중구");
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=== 끝====");
	}
	
}
