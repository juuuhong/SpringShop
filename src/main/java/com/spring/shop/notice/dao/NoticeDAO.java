package com.spring.shop.notice.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.notice.dto.NoticeDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 글 작성
	public int insertNotice(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).insertNotice(dto);
	}
	// 공지사항 게시글 전체 가져오기
	public List<NoticeDTO> noticeList() {
		return sqlSession.getMapper(NoticeMapper.class).noticeList();
	}
	// 글 한개 가져오기
	public NoticeDTO noticeContent(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).noticeContent(dto);
	}
	
	// 조회수+1
	public void readcountUp(NoticeDTO dto) {
		sqlSession.getMapper(NoticeMapper.class).readcountUp(dto);
	}
	
	// 글 수정
	public int noticeModify(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).noticeModify(dto);
	}
	
	// 글 삭제
	 public int noticeDelete(NoticeDTO dto) {
		 return sqlSession.getMapper(NoticeMapper.class).noticeDelete(dto);
	}
	public int insertAttach(Map<String, Object> param) {
		return sqlSession.getMapper(NoticeMapper.class).insertAttach(param);
		
	}
	
	// 파일이 저장되어 있으면 가져오기
	public String getFile(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).getFile(dto);
	}
}
