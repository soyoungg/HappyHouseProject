package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Notice;
import com.ssafy.happyhouse.repo.NoticeRepo;
import com.ssafy.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepo repo;
	
	@Override
	public int writeNotice(Notice notice) throws Exception {
		return repo.writeNotice(notice);
	}

	@Override
	public Notice getNotice(int notice_no) throws Exception {
		return repo.getNotice(notice_no);
	}

	@Override
	public int deleteNotice(int notice_no) throws Exception {
		return repo.deleteNotice(notice_no);
	}

	@Override
	public int modifyNotice(Notice notice, Notice origin) throws Exception {
		if(notice.getNotice_type() == null) {
			notice.setNotice_type(origin.getNotice_type());
		}else if(notice.getNotice_title() == null) {
			notice.setNotice_title(origin.getNotice_title());
		}else if(notice.getNotice_content() == null) {
			notice.setNotice_content(origin.getNotice_content());
		}
		
		return repo.modifyNotice(notice);
	}

	@Override
	public List<Notice> listNotice() throws Exception {
		// TODO Auto-generated method stub
		return repo.listNotice();
	}

	@Override
	public List<Notice> listNoticewp(int offset, int limit) throws Exception {
		// TODO Auto-generated method stub
		return repo.listNoticewp(offset, limit);
	}

}
