package com.ssafy.happyhouse.service;

import java.util.Map;

import com.ssafy.happyhouse.model.User;

public interface JwtService {

	<T> String create(String key, T data, String subject);
	Map<String, Object> get(String key);
	boolean isUsable(String jwt);
	//User getUser();
}
