package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

public interface AdminDashboardService {
	
	public List<Map<String, Integer>> countByUserSex() throws Exception;
	
	public List<Map<String, Integer>> countByUserAge() throws Exception;
	
	public List<Map<String, Integer>> countApt() throws Exception;
}
