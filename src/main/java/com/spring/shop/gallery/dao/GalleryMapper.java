package com.spring.shop.gallery.dao;

import java.util.List;
import java.util.Map;

import com.spring.shop.gallery.dto.GalleryDTO;

public interface GalleryMapper {
	// 갤러리 글 저장
	int insertGallery(GalleryDTO dto);
	int insertAttach(Map<String, Object> param);
	// 갤러리 리스트 가져오기
	List<GalleryDTO> galleryList();
}
