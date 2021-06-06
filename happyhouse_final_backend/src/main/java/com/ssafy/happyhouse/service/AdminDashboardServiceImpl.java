package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repo.AdminDashboardRepo;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService{

	@Autowired
	private AdminDashboardRepo repo;
	

	@Override
	public List<Map<String, Integer>> countByUserSex() throws Exception {
		// TODO Auto-generated method stub
		return repo.countByUserSex();
	}

	@Override
	public List<Map<String, Integer>> countByUserAge() throws Exception {
		// TODO Auto-generated method stub
		return repo.countByUserAge();
	}

	@Override
	public List<Map<String, Integer>> countApt() throws Exception {
		// TODO Auto-generated method stub
		return repo.countApt();
	}

}
