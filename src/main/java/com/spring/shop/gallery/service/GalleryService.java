package com.spring.shop.gallery.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.gallery.dto.GalleryDTO;

public interface GalleryService {
	// 갤러리 글 저장
	int insertGallery(GalleryDTO dto, HttpServletRequest req) throws IOException;
	// 갤러리 리스트 가져오기
	List<GalleryDTO> galleryList();

}
