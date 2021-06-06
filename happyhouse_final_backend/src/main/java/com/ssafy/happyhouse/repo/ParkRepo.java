package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Park;

public interface ParkRepo {
	public List<Map<String, Object>> topPark() throws SQLException;
	
	public List<Park> listPark(String park_address) throws SQLException;
}	
