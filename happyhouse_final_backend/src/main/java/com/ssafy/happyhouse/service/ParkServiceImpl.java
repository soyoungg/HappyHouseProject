package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Park;
import com.ssafy.happyhouse.repo.ParkRepo;

@Service
public class ParkServiceImpl implements ParkService{
	@Autowired 
	private ParkRepo repo;
	@Override
	public List<Map<String, Object>> topPark() throws Exception {
		// TODO Auto-generated method stub
		return repo.topPark();
	}

	@Override
	public List<Park> listPark(String park_address) throws Exception {
		// TODO Auto-generated method stub
		return repo.listPark(park_address);
	}
	
}
