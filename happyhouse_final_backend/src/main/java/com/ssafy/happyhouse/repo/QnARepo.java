package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.Answer;
import com.ssafy.happyhouse.model.QnA;
@Mapper
public interface QnARepo {
	public int writeQnA(QnA qna) throws SQLException;
	public int modifyQnA(QnA qna) throws SQLException;
	public int deleteQnA(int qna_no) throws SQLException;
	public int getQnATotalCount(Map<String, String> map) throws SQLException;
	public List<QnA> listQnA() throws SQLException;
	public List<QnA> listQnAwp(@Param("offset") int offset, @Param("limit") int limit) throws SQLException;
	public QnA getQnA(int qna_no) throws SQLException;
}
