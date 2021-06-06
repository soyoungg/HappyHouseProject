package com.ssafy.happyhouse.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.User;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/**
 * Handles requests for the application home page.
 */
@RestController
@CrossOrigin("*")
@Api("User 컨트롤러 API V1")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	final String SUCCESS = "success";
	final String FAIL = "fail";
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println("controllertest");
		System.out.println(map.get("user_id"));
		System.out.println(map.get("user_password"));
		System.out.println("return test");
		
		User user = userService.login(map);
		HttpStatus status = null;
		
		if(user.getUser_id() != null && user.getUser_password() != null) {
			String token = jwtService.create("user_id", user.getUser_id(), "access-token");
			resultMap.put("access-token", token);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} else {
			resultMap.put("message", FAIL);
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 회원가입
	@PostMapping("/user")
	public ResponseEntity<String> registUser(@RequestBody User user) throws Exception{
		int cnt = userService.registerUser(user);
		if(cnt != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	//회원정보 얻어오기
	@GetMapping("/user/{user_id}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("user_id") @ApiParam(value = "인증할 회원의 아이디.", required = true) String user_id,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				User user = userService.getUser(user_id);
				resultMap.put("userInfo", user);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}


	
	// 회원 정보 수정
	@PutMapping(value = "/user")
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user, HttpServletRequest request) throws Exception{
		HttpStatus status = HttpStatus.ACCEPTED;
		Map<String, Object> resultMap = new HashMap<>();
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			String user_id = user.getUser_id();
			try {
//				로그인 사용자 정보.
				User origin = userService.getUser(user_id);
				User updatedUser = userService.modifyUser(user, origin); // 새로 입력한 user, 기존의 origin
				resultMap.put("userInfo", updatedUser);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보수정 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 비밀번호 찾기
	@PostMapping(value = "/findPw")
	   public ResponseEntity<String> findPw(@RequestBody Map<String, String> map) throws Exception {
    	  String pw = userService.findPw(map);
    	  if(pw != null) {
    		  return new ResponseEntity<String>(pw, HttpStatus.OK);
    	  } else {
    		  return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    	  }
	   }
	
	// 회원탈퇴
	@DeleteMapping("/user/{user_id}")
	public ResponseEntity<String> deleteUser(@PathVariable("user_id") String user_id, HttpServletRequest request, HttpSession session) throws Exception {
		HttpStatus status = HttpStatus.ACCEPTED;
		String res = null;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
				if(userService.deleteUser(user_id) > 0) {
					session.invalidate();
					status = HttpStatus.OK;
					res = SUCCESS;
				}
			} catch (Exception e) {
				logger.error("탈퇴 실패 : {}", e);
				res = FAIL;
				status = HttpStatus.NO_CONTENT;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			res = FAIL;
			status = HttpStatus.FORBIDDEN;
		}
		return new ResponseEntity<String>(res, status);
	}
}
