package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Restaurant;
import com.ssafy.happyhouse.repo.RestaurantRepo;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepo repo;
	
	@Override
	public List<Map<String, Object>> topRestaurant() throws Exception {
		// TODO Auto-generated method stub
		return repo.topRestaurant();
	}
	
	@Override
	public List<Restaurant> listRestaurant(String restaurant_address) throws Exception {
		return repo.listRestaurant(restaurant_address);
	}

}
