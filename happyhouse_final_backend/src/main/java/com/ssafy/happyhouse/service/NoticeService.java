package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Notice;
import com.ssafy.util.PageNavigation;

public interface NoticeService {

	// 공지 사항 추가
	public int writeNotice(Notice notice) throws Exception;
	
	// 공지 사항 세부 읽기
	public Notice getNotice(int notice_no) throws Exception;
	
	// 공지 사항 삭제
	public int deleteNotice(int notice_no) throws Exception;
	
	// 공지 사항 수정
	public int modifyNotice(Notice notice, Notice origin) throws Exception;
	
	// 목록
	public List<Notice> listNotice() throws Exception;
	
	// 목록
		public List<Notice> listNoticewp(int offset, int limit) throws Exception;
	
	// 공지사항 페이징
	//public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
}
