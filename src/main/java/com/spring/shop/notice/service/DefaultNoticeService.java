package com.spring.shop.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.notice.dao.NoticeDAO;
import com.spring.shop.notice.dto.NoticeDTO;

@Service
public class DefaultNoticeService implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public int insertNotice(NoticeDTO dto) {
		return noticeDAO.insertNotice(dto);
	}
	
}
