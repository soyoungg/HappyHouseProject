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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Notice;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.NoticeService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("Notice 컨트롤러 API V1")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private NoticeService service;
	
	@Autowired
	private JwtService jwtService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	final String NO = "권한이 없습니다";
	
	// 목록
	@PostMapping(value="/notice/list")
	public ResponseEntity<List<Notice>> listNotice(@RequestBody Map<String, String> map) throws Exception {
		System.out.println(map.toString());
		int offset = Integer.parseInt(map.get("offset"));
		int limit = Integer.parseInt(map.get("limit"));
		List<Notice> list = service.listNoticewp(offset, limit);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Notice>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
//	@PostMapping(value="/notice")
//	public ResponseEntity<List<Notice>> listNotice() throws Exception {
//		List<Notice> list = service.listNotice();
//		if(list != null && !list.isEmpty()) {
//			return new ResponseEntity<List<Notice>>(list, HttpStatus.OK);
//		} else {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//	}
	
	// 등록
	@PostMapping(value="/notice")
	public ResponseEntity<String> writeNotice(@RequestBody Notice notice, HttpServletRequest request) throws Exception {
		
			int cnt = service.writeNotice(notice);
			if(cnt != 0) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
	}
	
	// 수정
	@PutMapping(value="/notice")
	public ResponseEntity<String> modifyNotice(@RequestBody Notice notice, HttpServletRequest request) throws Exception {
		
			Notice origin = service.getNotice(notice.getNotice_no());
			int cnt = service.modifyNotice(notice, origin);
			if(cnt != 0) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
	
	
	// 삭제
	@DeleteMapping(value="/notice/{notice_no}")
	public ResponseEntity<String> deleteNotice(@PathVariable("notice_no") int notice_no, HttpServletRequest request) throws Exception {
		
			int cnt = service.deleteNotice(notice_no);
			if(cnt != 0) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}
	
	// 상세보기
	@GetMapping(value="/notice/{notice_no}")
	public ResponseEntity<Notice> getNotice(@PathVariable("notice_no") int notice_no ) throws Exception {
		Notice notice = service.getNotice(notice_no);
		if(notice != null) {
			return new ResponseEntity<Notice>(notice, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
}
