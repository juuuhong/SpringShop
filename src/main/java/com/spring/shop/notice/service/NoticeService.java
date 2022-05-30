package com.spring.shop.notice.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.spring.shop.notice.dto.NoticeDTO;

public interface NoticeService {
	int insertNotice(NoticeDTO dto, HttpServletRequest req) throws IOException;
	List<NoticeDTO> noticeList();
	NoticeDTO noticeContent(NoticeDTO dto);
	String getFile(NoticeDTO dto);
	void readcountUp(NoticeDTO dto);
	int noticeModify(NoticeDTO dto, HttpServletRequest req) throws IOException;
	int noticeDelete(NoticeDTO dto, HttpServletRequest req);
	
	//Map<String, Object> uploadImg(MultipartFile img);
}
