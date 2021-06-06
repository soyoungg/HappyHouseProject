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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.model.QnA;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin("*")
@Api("QnA 컨트롤러 API V1")
public class QnAController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private QnAService qnaService;
	
	@Autowired
	private JwtService jwtService;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	// 목록
	@PostMapping("/qna/list")
	public ResponseEntity<List<QnA>> listQnA(@RequestBody Map<String, String> map) throws Exception {
		System.out.println(map.toString());
		int offset = Integer.parseInt(map.get("offset"));
		int limit = Integer.parseInt(map.get("limit"));
		List<QnA> list = qnaService.listQnAwp(offset, limit);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<QnA>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	// QnA 작성
	@PostMapping(value = "/qna")
	public ResponseEntity<String> writeQnA(@RequestBody QnA qna, HttpServletRequest request) throws Exception {
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			int cnt = qnaService.writeQnA(qna);
			if(cnt != 0) {
				return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			}
		}else {
			return new ResponseEntity<String>("FAIL", HttpStatus.FORBIDDEN);
		}
	}
	
	// QnA 수정
	@PutMapping(value = "/qna")
	public ResponseEntity<String> modifyQnA(@RequestBody QnA qna, HttpServletRequest request) throws Exception {
		String str = null;
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			QnA origin = qnaService.getQnA(qna.getQna_no());
			String originWriter = origin.getQna_author();
			String nowWriter = qna.getQna_author();
			if(nowWriter.equals(originWriter)) { // 본인이 쓴 글일때
				int res = qnaService.modifyQnA(qna, origin);
				if(res != 0) 
					return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			else { // 본인이 쓴 글이 아님 
				str = FAIL;
			}
		}else {
			str = FAIL;
		}
		return new ResponseEntity<String>(str, HttpStatus.FORBIDDEN);
	}
	
	// QnA 삭제
	@DeleteMapping(value = "/qna/{qna_no}")
	public ResponseEntity<String> deleteQnA(@PathVariable("qna_no") int qna_no, HttpServletRequest request, HttpSession session) throws Exception {
		String str = null;
		if(jwtService.isUsable(request.getHeader("access-token"))) {
			String originWriter = qnaService.getQnA(qna_no).getQna_author();
			String nowWriter = session.getId();
			if(nowWriter.equals(originWriter)) { // 본인이 쓴 글일때
				int res = qnaService.deleteQnA(qna_no);
				if(res != 0) 
					return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			else { // 본인이 쓴 글이 아님 
				str = FAIL;
			}
		}else {
			str = FAIL;
		}
		return new ResponseEntity<String>(str, HttpStatus.FORBIDDEN);
	}
	
	// QnA 상세보기
	@GetMapping(value = "/qna/{qna_no}")
	public ResponseEntity<QnA> getQnA(@PathVariable("qna_no") int qna_no) throws Exception {
		QnA qna = qnaService.getQnA(qna_no);
		if(qna != null) return new ResponseEntity<QnA>(qna, HttpStatus.OK);
		else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
