package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Restaurant;

public interface RestaurantRepo {

	public List<Map<String, Object>> topRestaurant() throws SQLException;
	
	public List<Restaurant> listRestaurant(String restaurant_address) throws SQLException;
}
