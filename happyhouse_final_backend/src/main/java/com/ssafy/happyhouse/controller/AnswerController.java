package com.ssafy.happyhouse.controller;

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

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.service.AnswerService;
import com.ssafy.happyhouse.service.JwtService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("Answer 컨트롤러 API V1")
public class AnswerController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private AnswerService answerService;
	
	
	@Autowired
	private JwtService jwtService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	

	// 댓글 작성
	@PostMapping(value="/answer")
	public ResponseEntity<String> writeAnswer(@RequestBody Answer answer, HttpServletRequest request) throws Exception {
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			int res = answerService.writeAnswer(answer);
			if(res != 0) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity(FAIL, HttpStatus.FORBIDDEN);
		}
	}
	
	// 댓글 수정
	@PutMapping(value="/answer/{answer_no}")
	public ResponseEntity<String> modifyAnswer(@RequestBody Answer answer, HttpServletRequest request) throws Exception {
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			int res = answerService.modifyAnswer(answer);
			if(res != 0) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity(FAIL, HttpStatus.FORBIDDEN);
		}
	}
	
	
	// 댓글 삭제
	@DeleteMapping(value="/answer/{answer_no}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("answer_no") int answer_no, HttpServletRequest request) throws Exception {
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			int res = answerService.deleteAnswer(answer_no);
			if(res != 0) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity(FAIL, HttpStatus.FORBIDDEN);
		}
	}
	
	// 댓글 전체보기
	@GetMapping(value = "/answer/{qna_no}")
	public ResponseEntity<List<Answer>> listAnswer(@PathVariable("qna_no") int qna_no) throws Exception {
		List<Answer> list = answerService.listAnswer(qna_no);
		if(list != null) return new ResponseEntity<List<Answer>>(list, HttpStatus.OK);
		else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	

}
