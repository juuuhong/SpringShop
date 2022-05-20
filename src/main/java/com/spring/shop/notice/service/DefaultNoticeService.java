package com.spring.shop.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.notice.dao.NoticeDAO;
import com.spring.shop.notice.dto.NoticeDTO;

@Service
public class DefaultNoticeService implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<NoticeDTO> noticeList() {
		return noticeDAO.noticeList();
	}

	@Override
	public int insertNotice(NoticeDTO dto) {
		return noticeDAO.insertNotice(dto);
	}

	@Override
	public NoticeDTO noticeContent(NoticeDTO dto) {
		return noticeDAO.noticeContent(dto);
	}

	@Override
	public void readcountUp(NoticeDTO dto) {
		noticeDAO.readcountUp(dto);
		
	}

	@Override
	public int noticeModify(NoticeDTO dto) {
		return noticeDAO.noticeModify(dto);
	}


	/*
	 * @Override public int noticeDelete(NoticeDTO dto) { return
	 * noticeDAO.noticeDelete(dto); }
	 */
	
}
