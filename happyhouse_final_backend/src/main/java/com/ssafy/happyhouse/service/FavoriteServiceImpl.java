package com.ssafy.happyhouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.repo.FavoriteRepo;

@Service
public class FavoriteServiceImpl implements FavoriteService{

	@Autowired
	private FavoriteRepo repo;
	
	@Override
	public int registLike(Like like) throws Exception {
		// TODO Auto-generated method stub
		return repo.registLike(like);
	}

	@Override
	public int deleteLike(Like like) throws Exception {
		// TODO Auto-generated method stub
		return repo.deleteLike(like);
	}

	@Override
	public List<String> listLike(String user_id) throws Exception {
		// TODO Auto-generated method stub
		List<String> tmp= repo.listLike(user_id);
		List<String> list = new ArrayList<>();
		for (String str: tmp) {
			if(str != null) {
				list.add(str);
			}
		}
		return list;
	}
}
