package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Park;

public interface ParkService {
	public List<Map<String, Object>> topPark() throws Exception;
	
	public List<Park> listPark(String park_address) throws Exception;
}
