package com.spring.shop.notice.service;

import java.util.List;

import com.spring.shop.notice.dto.NoticeDTO;

public interface NoticeService {
	int insertNotice(NoticeDTO dto);
	List<NoticeDTO> noticeList();
	NoticeDTO noticeContent(NoticeDTO dto);
	void readcountUp(NoticeDTO dto);
	int noticeModify(NoticeDTO dto);
	int noticeDelete(NoticeDTO dto);
}
