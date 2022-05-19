package com.spring.shop.notice.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.notice.dto.NoticeDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// ±€ ¿€º∫
	public int insertNotice(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).insertNotice(dto);
	}
}
