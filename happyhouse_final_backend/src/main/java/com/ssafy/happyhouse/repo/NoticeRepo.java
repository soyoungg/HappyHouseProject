package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.Notice;
@Mapper
public interface NoticeRepo {
	public int writeNotice(Notice notice) throws SQLException;
	
	public int modifyNotice(Notice notice) throws SQLException;
	
	public int deleteNotice(int notice_no) throws SQLException;
	
	public int getTotalNoticeCount(Map<String, String> map) throws SQLException;
	
	public List<Notice> listNotice() throws SQLException;
	
	public List<Notice> listNoticewp(@Param("offset") int offset, @Param("limit") int limit) throws SQLException;
	
	
	public Notice getNotice(int notice_no) throws SQLException;
}
