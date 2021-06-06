package com.ssafy.happyhouse.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Like;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.FavoriteService;
import com.ssafy.happyhouse.service.NoticeService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("Like 컨트롤러 API V1")
public class LikeController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private FavoriteService likeService;
	
	@Autowired
	private JwtService jwtService;
	

	@PostMapping("/like")
	public ResponseEntity<String>registerPlace(@RequestBody Like like, HttpServletRequest request) throws Exception{
		System.out.println("start registerPlace");
		System.out.println(request.getHeader("access-token"));
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			System.out.println("hi");
			int cnt = likeService.registLike(like);
			if(cnt != 0) {
				System.out.println("success");
				return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}else {
				System.out.println("fail");
				return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			}
		}else {
			System.out.println("no access token");
			return new ResponseEntity<String>("FAIL", HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/like/delete")
	public ResponseEntity<?>deleteLike(@RequestBody Like like, HttpServletRequest request) throws Exception{
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			int cnt = likeService.deleteLike(like);
			if(cnt != 0) {
				return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			}
		}else {
			return new ResponseEntity<String>("FAIL", HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/like/{user_id}")
	public ResponseEntity<List<String>>listLike(@PathVariable("user_id") String user_id ,HttpServletRequest request) throws Exception{
		System.out.println("like test");
		//if(jwtService.isUsable(request.getHeader("access-token"))) {
			List<String> list = likeService.listLike(user_id);
			System.out.println("list : " + list.size());
			for(String str : list) 
				System.out.println(str);
			if(list != null ){//&& !list.isEmpty()) {
				System.out.println("success!!");
				return new ResponseEntity<List<String>>(list,HttpStatus.OK);
			}else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
//		}else {
//			return new ResponseEntity(HttpStatus.FORBIDDEN);
//		}
	}
}
