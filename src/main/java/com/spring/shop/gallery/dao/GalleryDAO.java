package com.spring.shop.gallery.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.gallery.dto.GalleryDTO;
import com.spring.shop.notice.dao.NoticeMapper;
import com.spring.shop.notice.dto.NoticeDTO;

@Repository
public class GalleryDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// �� �ۼ�
	public int insertGallery(GalleryDTO dto) {
		return sqlSession.getMapper(GalleryMapper.class).insertGallery(dto);
	}
	public int insertAttach(Map<String, Object> param) {
		return sqlSession.getMapper(GalleryMapper.class).insertAttach(param);
	}
	
	// ������ ����Ʈ ��������
	public List<GalleryDTO> galleryList(){
		return sqlSession.getMapper(GalleryMapper.class).galleryList();
	}
	
	// ������ ��������
	public GalleryDTO galleryContent(GalleryDTO dto) {
		return sqlSession.getMapper(GalleryMapper.class).galleryContent(dto);
	}
	
	// ��ȸ��+1
	public void readcountUp(GalleryDTO dto) {
		sqlSession.getMapper(GalleryMapper.class).readcountUp(dto);
	}
	
	// ������ ����
	public int galleryModify(GalleryDTO dto) {
		return sqlSession.getMapper(GalleryMapper.class).galleryModify(dto);
	}
	
	// �� ����
	 public int galleryDelete(GalleryDTO dto) {
		 return sqlSession.getMapper(GalleryMapper.class).galleryDelete(dto);
	}
}
