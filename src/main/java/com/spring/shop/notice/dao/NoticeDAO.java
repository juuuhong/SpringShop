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
	
	// �� �ۼ�
	public int insertNotice(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).insertNotice(dto);
	}
	// �������� �Խñ� ��ü ��������
	public List<NoticeDTO> noticeList() {
		return sqlSession.getMapper(NoticeMapper.class).noticeList();
	}
	// �� �Ѱ� ��������
	public NoticeDTO noticeContent(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).noticeContent(dto);
	}
	
	// ��ȸ��+1
	public void readcountUp(NoticeDTO dto) {
		sqlSession.getMapper(NoticeMapper.class).readcountUp(dto);
	}
	
	// �� ����
	public int noticeModify(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).noticeModify(dto);
	}
	
	// �� ����
	 public int noticeDelete(NoticeDTO dto) {
		 return sqlSession.getMapper(NoticeMapper.class).noticeDelete(dto);
	}
	public int insertAttach(Map<String, Object> param) {
		return sqlSession.getMapper(NoticeMapper.class).insertAttach(param);
		
	}
	
	// ������ ����Ǿ� ������ ��������
	public String getFile(NoticeDTO dto) {
		return sqlSession.getMapper(NoticeMapper.class).getFile(dto);
	}
}
