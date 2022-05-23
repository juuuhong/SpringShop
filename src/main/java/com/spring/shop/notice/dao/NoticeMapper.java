package com.spring.shop.notice.dao;

import java.util.List;
import java.util.Map;

import com.spring.shop.notice.dto.NoticeDTO;

public interface NoticeMapper {
	int insertNotice(NoticeDTO dto);
	List<NoticeDTO> noticeList();
	NoticeDTO noticeContent(NoticeDTO dto);
	void readcountUp(NoticeDTO dto);
	int noticeModify(NoticeDTO dto);
	int noticeDelete(NoticeDTO dto);
	int insertAttach(Map<String, Object> param);
	String getFile(NoticeDTO dto);
}
