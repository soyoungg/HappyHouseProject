package com.ssafy.happyhouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.service.FavoriteService;
import com.ssafy.happyhouse.service.HouseDealService;

@SpringBootTest
public class housedealtest {
	@Autowired
	HouseDealService ser;
	
	@Test
	public void pricechange() {
		Map<String, String> map = new HashMap<>();
		map.put("aptname", "포레스트힐시티");
		map.put("floor", "12");
		List<viewApart> list = ser.priceChange(map);
		for (viewApart va : list) {
			System.out.println(va);
		}
		
	}
	
}
