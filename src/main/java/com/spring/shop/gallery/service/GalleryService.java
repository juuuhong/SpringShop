package com.spring.shop.gallery.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.gallery.dto.GalleryDTO;

public interface GalleryService {
	// ������ �� ����
	int insertGallery(GalleryDTO dto, HttpServletRequest req) throws IOException;
	// ������ ����Ʈ ��������
	List<GalleryDTO> galleryList();
	// ������ ��������
	GalleryDTO galleryContent(GalleryDTO dto);
	// ��ȸ��+1
	void readcountUp(GalleryDTO dto);
	// ������ ����
	int galleryModify(GalleryDTO dto);
	// ������ ����
	int galleryDelete(GalleryDTO dto);
}
