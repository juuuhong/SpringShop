package com.spring.shop.gallery.dao;

import java.util.List;
import java.util.Map;

import com.spring.shop.gallery.dto.GalleryDTO;

public interface GalleryMapper {
	// ������ �� ����
	int insertGallery(GalleryDTO dto);
	int insertAttach(Map<String, Object> param);
	// ������ ����Ʈ ��������
	List<GalleryDTO> galleryList();
}
