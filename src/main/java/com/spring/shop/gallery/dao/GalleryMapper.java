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
	// 갤러리 상세페이지
	GalleryDTO galleryContent(GalleryDTO dto);
	// 조회수+1
	void readcountUp(GalleryDTO dto);
	// 갤러리 수정
	int galleryModify(GalleryDTO dto);
	// 갤러리 삭제
	int galleryDelete(GalleryDTO dto);
	
}
