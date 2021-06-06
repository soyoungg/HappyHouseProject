package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Restaurant;
import com.ssafy.happyhouse.service.RestaurantService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("Restaurant 컨트롤러 API V1")
public class RestaurantController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RestaurantService service;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	// 제일 처음 로딩 되면 top 5 가져옴
	@GetMapping("/restaurant")
	public ResponseEntity<List<Map<String, Object>>> top5RestaurantAddr() throws Exception {
		
		List<Map<String, Object>> top5 = service.topRestaurant();
		
		if(top5 != null && !top5.isEmpty()) {
			return new ResponseEntity<List<Map<String, Object>>>(top5, HttpStatus.OK);
		} else
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/restaurant/{restaurant_address}")
	public ResponseEntity<List<Restaurant>> listRestaurant(@PathVariable("restaurant_address") String restaurant_address) throws Exception {
		List<Restaurant> restaurantDetail = service.listRestaurant(restaurant_address);
		if(restaurantDetail != null && !restaurantDetail.isEmpty()) {
			return new ResponseEntity<List<Restaurant>>(restaurantDetail, HttpStatus.OK);
		} else
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
