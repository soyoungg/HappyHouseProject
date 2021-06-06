package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AdminDashboardRepo {
	
	public List<Map<String, Integer>> countByUserSex() throws SQLException;

	public List<Map<String, Integer>> countByUserAge() throws SQLException;

	public List<Map<String, Integer>> countApt() throws SQLException;
}
