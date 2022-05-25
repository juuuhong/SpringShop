package com.spring.shop.gallery.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.gallery.dto.GalleryDTO;

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
}
