package com.ssafy.happyhouse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.happyhouse.model.User;
import com.ssafy.happyhouse.service.UserService;

@SpringBootTest
public class userTest {
	
	@Autowired
	UserService ser;
//	
//	@Test
//	void registUser() throws Exception {
//		System.out.println("=======사용자 등록=======");
//		User user = new User("usertest", "usertest", "usertest", "male", 40,"010-1234-5678", "user@user.com");
//		int sys = ser.registerUser(user);
//		System.out.println(sys);
//		System.out.println("=== 끝====");
//	}
//	
//	@Test
//	void getUser() throws Exception {
//		System.out.println("=====회원 조회=====");
//		String user_id = "test4";
//		User login = ser.getUser(user_id);
//		System.out.println(login);
//		System.out.println("=== 끝====");
//	}
//	
//	
//	@Test
//	void modifyUser() {
//		System.out.println("정보 수정");
//		UserDto userDto = new UserDto("kossafy","kossafy", "kossafy","010-9999-9999","987654@gmail.com");
//		
//		int sys = ser.modifyUser(userDto);
//		System.out.println(sys);
//		String id = userDto.getUserId();
//		userDto = ser.getUser(id);
//		System.out.println(userDto);
//		System.out.println("끝");
//	}
//	@Test
//	void deleteUser() throws Exception {
//		String id ="usertest";
//		int sys = ser.deleteUser(id);
//		System.out.println(sys);
//	}
//	
//	@Test
//	void findPw() throws Exception {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("user_id", "test4");
//		map.put("user_name", "test4");
//		
//		String pw = ser.findPw(map);
//		System.out.println(pw);
//	}
//	
//	@Test
//	void login() {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("userId", "aaa");
//		map.put("userPwd", "aaa");
//		
//		UserDto user = ser.login(map);
//		System.out.println(user);
//		
//	}
	
	
}
