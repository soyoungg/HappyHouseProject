package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Restaurant;

public interface RestaurantService {
	
	public List<Map<String, Object>> topRestaurant() throws Exception;
	
	public List<Restaurant> listRestaurant(String restaurant_address) throws Exception;
}
