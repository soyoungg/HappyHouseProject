package com.ssafy.happyhouse.repo;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Apart;
import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.Location;
import com.ssafy.happyhouse.model.New_apart;
import com.ssafy.happyhouse.model.New_apt_register;
import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.Like;

public interface Aptrepo {
	List<String> city_list(String city);

	List<String> gugun_list(String city);

	List<String> dong_list(Map<String, String> map);

	List<HouseDeal> apart_list(String dong);

	List<HouseDeal> apt_list(String apt);

	List<New_apart> new_apt_list(Map<String, String> map);

	int new_apt_regist(New_apt_register reg);

	int new_apt_delete(int idx);

	List<Like> getAllList(String userid);

	int registerPlace(Like place);

	int deletePlace(String placeName);
	
	List<viewApart> priceChange(Map<String, String> map);
}
