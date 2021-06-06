package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.model.User;


public interface UserRepo {
	
	// 회원 가입
	public int insertUser(User user) throws SQLException;
	
	// 로그인
	public User login(Map<String, String> map) throws SQLException;
	
	// 회원정보수정을 위한 회원의 모든 정보 얻기
	public User getUser(String user_id) throws SQLException;
	
	// 회원 정보 수정
	public int updateUser(User user) throws SQLException;
	
	// 회원 탈퇴
	public int deleteUser(String userId);
	
	// 비번찾기
	public String findPw(Map<String, String> map);

}
