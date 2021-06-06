package com.ssafy.happyhouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.viewApartInt;
import com.ssafy.happyhouse.repo.UserDashboardRepo;

@Service
public class UserDashboardServiceImpl implements UserDashboardService{

	@Autowired 
	private UserDashboardRepo repo;
	
	@Override
	public String suggestByUser(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return repo.suggestByUser(map);
	}

	@Override
	public List<viewApartInt> priceChange(Map<String, String> map) throws Exception {
		for(Entry<String, String> entity : map.entrySet()) {
			System.out.println(entity);
		}
		List<viewApart> tmp = repo.priceChange(map);
		List<viewApartInt> list = new ArrayList<>();
		String str = null;
		for (int i = 0; i < tmp.size(); i++) {
			viewApart old = tmp.get(i);
			str = old.getDealamount().trim();
			int price = Integer.parseInt(str.replace(",", ""));
			StringBuilder sb = new StringBuilder();
			
			sb.append(old.getDealyear()).append("-").append(old.getDealmonth()).append("-").append(old.getDealday());
			
			viewApartInt res = new viewApartInt(old.getAptname(), sb.toString(), price, old.getBuildyear(), old.getArea(), old.getFloor());
			list.add(res);
		}

//		for(viewApartInt t : list) System.out.println(t);
		return list;
	}

}
