package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.User;
import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.model.viewApartInt;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.UserDashboardService;
import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("UserDashboard 컨트롤러 API V1")
public class UserDashboardController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDashboardService userDashboardService;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	// 
	@PostMapping(value="/userboard/{user_id}")
	public ResponseEntity<List<viewApartInt>> userDashboard
	(@RequestBody Map<String, String> map,HttpServletRequest request) throws Exception {
		System.out.println("enter price change");
//		if (jwtService.isUsable(request.getHeader("access-token"))) {
			List<viewApartInt> res = userDashboardService.priceChange(map);
			if(res!= null && !res.isEmpty()) {
				System.out.println("success loading favorite lists");
//				for(viewApartInt apt : res) System.out.println(res);
				return new ResponseEntity<List<viewApartInt>>(res, HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}else {
//			return new ResponseEntity(HttpStatus.FORBIDDEN);
//		}
	}
}
