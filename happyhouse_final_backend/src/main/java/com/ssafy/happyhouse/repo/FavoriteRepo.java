package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Like;

public interface FavoriteRepo {
	public int registLike(Like like) throws SQLException;
	
	public int deleteLike(Like like) throws SQLException;
	
	public List<String> listLike(String user_id)  throws SQLException;
}
