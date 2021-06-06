package com.ssafy.happyhouse;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.viewApartInt;
import com.ssafy.happyhouse.service.UserDashboardService;


@SpringBootTest
public class userdashboardTest {
	@Autowired
	UserDashboardService ser;
	
	@Test
	void priceChange() throws Exception {
		System.out.println("===가격변동=======");
//		List<viewApartInt> list = ser.priceChange("hodong");
//		for (viewApartInt tmp : list) {
//			System.out.println(tmp);
//		}
//		
		
	}
	
}
