package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Like;

public interface FavoriteService {
	
	public int registLike(Like like) throws Exception;
	
	public int deleteLike(Like like) throws Exception;
	
	public List<String> listLike(String user_id)  throws Exception;
}
