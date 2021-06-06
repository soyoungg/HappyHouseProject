package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Apart;
import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.Location;
import com.ssafy.happyhouse.model.New_apart;
import com.ssafy.happyhouse.model.New_apt_register;
import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.model.User;
import com.ssafy.happyhouse.model.viewApart;
import com.ssafy.happyhouse.service.HouseDealService;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.FavoriteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/apt")
public class HouseDealController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private HouseDealService service;
	
	@Autowired
	private FavoriteService likeService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@PostMapping("/city_list")
	public ResponseEntity<?>city_list(Map<String, String> map){
		List<String> list =  service.city_list(map);
		if(list != null) {
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/gugun_list")
	public ResponseEntity<?>gugun_list(@RequestBody Map<String, String> map){
		List<String> list =  service.gugun_list(map);
		if(list != null) {
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/dong_list")
	public ResponseEntity<?>dong_list(@RequestBody Map<String, String> map){
		List<String> list =  service.dong_list(map);
		if(list != null) {
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/apart_list")
	public ResponseEntity<?>apart_list(@RequestBody Map<String, String> map){
		List<HouseDeal> list =  service.apart_list(map);
		if(list != null) {
			return new ResponseEntity<List<HouseDeal>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/apt_list")
	public ResponseEntity<?>apt_list(@RequestBody Map<String, String> map){
		List<HouseDeal> list =  service.apt_list(map);
		if(list != null) {
			return new ResponseEntity<List<HouseDeal>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/new_apt_list")
	public ResponseEntity<?>new_apt_list(@RequestBody Map<String, String> map){
		List<New_apart> list =  service.new_apt_list(map);
		if(list != null) {
			return new ResponseEntity<List<New_apart>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/new_apt_regist")
	public ResponseEntity<?>new_apt_regist(@RequestBody New_apt_register reg){
		if(service.new_apt_regist(reg)) {
			return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/new_apt_delete")
	public ResponseEntity<?>new_apt_delete(@RequestBody Map<String, String> map){
		if(service.new_apt_delete(map)) {
			return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 가격 변동
	@PostMapping("/viewApt")
	public ResponseEntity<?>viewApt(@RequestBody Map<String, String> map){
		List<viewApart> list = service.priceChange(map);
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} 
}
