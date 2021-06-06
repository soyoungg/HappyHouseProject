package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Apart;
import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.Location;
import com.ssafy.happyhouse.model.New_apart;
import com.ssafy.happyhouse.model.New_apt_register;
import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.Like;

public interface HouseDealService {
	List<String> city_list(Map<String, String> map);

	List<String> gugun_list(Map<String, String> map);

	List<String> dong_list(Map<String, String> map);

	List<HouseDeal> apart_list(Map<String, String> map);

	List<HouseDeal> apt_list(Map<String, String> map);

	List<New_apart> new_apt_list(Map<String, String> map);

	boolean new_apt_regist(New_apt_register reg);

	boolean new_apt_delete(Map<String, String> map);
	
	List<viewApart> priceChange(Map<String, String> map);
}
