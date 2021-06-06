package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Park;
import com.ssafy.happyhouse.service.ParkService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("Park 컨트롤러 API V1")
public class ParkController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ParkService parkService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	// 제일 처음 페이지 로딩되면 top 5 가져옴
	@GetMapping("/park")
	public ResponseEntity<List<Map<String, Object>>> top5Park() throws Exception {
		List<Map<String, Object>> list = parkService.topPark();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Map<String, Object>>>(list, HttpStatus.OK);
		} else
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/park/{park_address}")
	public ResponseEntity<List<Park>> listPark(@PathVariable("park_address") String park_address) throws Exception {
		List<Park> parkDetail = parkService.listPark(park_address);
		if(parkDetail != null && !parkDetail.isEmpty()) {
			return new ResponseEntity<List<Park>>(parkDetail, HttpStatus.OK);
		} else
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
	}

	
}
