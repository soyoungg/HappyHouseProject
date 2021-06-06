package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.viewApart;

public interface UserDashboardRepo {
	
	public String suggestByUser(Map<String, String> map) throws SQLException;
	
	public List<viewApart> priceChange(Map<String, String> map) throws SQLException;
}



