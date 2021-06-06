package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.service.AdminDashboardService;
import com.ssafy.happyhouse.service.JwtService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("AdminDashboard 컨트롤러 API V1")
public class AdminDashboardController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private AdminDashboardService adminService;
	
	@Autowired
	private JwtService jwtService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@GetMapping(value="/adminboard")
	public ResponseEntity<List<Map<String, Integer>>> adminDashboard() throws Exception {
		
		
		List<Map<String, Integer>> admindb = adminService.countByUserSex();
		admindb.addAll(adminService.countByUserAge());
		admindb.addAll(adminService.countApt());
		
		
		if(admindb != null && !admindb.isEmpty()) {
			return new ResponseEntity<List<Map<String, Integer>>>(admindb, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
