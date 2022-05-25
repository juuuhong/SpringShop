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
	
	// 글 작성
	public int insertGallery(GalleryDTO dto) {
		return sqlSession.getMapper(GalleryMapper.class).insertGallery(dto);
	}
	public int insertAttach(Map<String, Object> param) {
		return sqlSession.getMapper(GalleryMapper.class).insertAttach(param);
	}
	
	// 갤러리 리스트 가져오기
	public List<GalleryDTO> galleryList(){
		return sqlSession.getMapper(GalleryMapper.class).galleryList();
	}
}
