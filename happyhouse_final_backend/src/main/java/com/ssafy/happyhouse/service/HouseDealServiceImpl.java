package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Apart;
import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.Location;
import com.ssafy.happyhouse.model.New_apart;
import com.ssafy.happyhouse.model.New_apt_register;
import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.repo.Aptrepo;

@Service
public class HouseDealServiceImpl implements HouseDealService{

	@Autowired
	Aptrepo repo;
	
	@Override
	public List<String> city_list(Map<String, String> map) {
		return repo.city_list(map.get("city"));
	}

	@Override
	public List<String> gugun_list(Map<String, String> map) {
		if(map.get("city") != null) {
			String city = map.get("city");
			return repo.gugun_list(city);
		}
		return null;
	}

	@Override
	public List<String> dong_list(Map<String, String> map) {
		if(map.get("city") != null && map.get("gugun") != null) {
			return repo.dong_list(map);			
		}
		return null;
	}

	@Override
	public List<HouseDeal> apart_list(Map<String, String> map) {
		if(map.get("dong") != null) {
			String dong = map.get("dong");
			return repo.apart_list(dong);
		}
		return null;
	}

	@Override
	public List<HouseDeal> apt_list(Map<String, String> map) {
		if(map.get("apt") != null) {
			String apt = map.get("apt");
			return repo.apt_list(apt);
		}
		return null;
	}

	@Override
	public List<New_apart> new_apt_list(Map<String, String> map) {
		return repo.new_apt_list(map);			
	}

	@Override
	public boolean new_apt_regist(New_apt_register reg) {
		if(reg.getApart_name() != null && 
			reg.getArea() != null &&
			reg.getBuild_year() != null &&
			reg.getFloor() != null &&
			reg.getPrice() != 0 &&
			reg.getZip_code() != null
			) {
			if(repo.new_apt_regist(reg) > 0)		
				return true;
		}
		return false;
	}

	@Override
	public boolean new_apt_delete(Map<String, String> map) {
		if(map.get("idx") != null) {
			int idx = Integer.parseInt(map.get("idx"));
			if(repo.new_apt_delete(idx) > 0)
				return true;
		}
		return false;
	}

	@Override
	public List<viewApart> priceChange(Map<String, String> map) {

		System.out.println(map.get("aptname"));
		System.out.println(map.get("floor"));
		return repo.priceChange(map);
	}
}
