package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.viewApartInt;

public interface UserDashboardService {
	public String suggestByUser(Map<String, String> map) throws Exception;
	
	public List<viewApartInt> priceChange(Map<String, String> map) throws Exception;
}