package com.spring.shop.notice.dao;

import com.spring.shop.notice.dto.NoticeDTO;

public interface NoticeMapper {
	int insertNotice(NoticeDTO dto);
	
}
