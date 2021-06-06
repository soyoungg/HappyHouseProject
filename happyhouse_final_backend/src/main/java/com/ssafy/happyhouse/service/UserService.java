package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.model.User;


public interface UserService {
	// 회원 가입
	int registerUser(User user) throws Exception;

	//	로그인
	User login(Map<String, String> map) throws Exception;
	
	//	회원정보 수정을 위한 회원의 모든 정보 얻기
	User getUser(String user_id) throws Exception;
	
	//	회원정보 수정
	User modifyUser(User user, User origin) throws Exception;
	
	//	회원탈퇴
	int deleteUser(String user_id) throws Exception;
	
	public String findPw(Map<String, String> map) throws Exception;
	
}
