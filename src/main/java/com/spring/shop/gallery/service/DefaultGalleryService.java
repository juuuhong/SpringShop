package com.spring.shop.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.FileService;
import com.spring.shop.gallery.dao.GalleryDAO;
import com.spring.shop.gallery.dto.GalleryDTO;

@Service
public class DefaultGalleryService implements GalleryService{
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	// ��������
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	//  ������ �� ����
	@Override
	public int insertGallery(GalleryDTO dto, HttpServletRequest req) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		Map<String, Object> param = new HashMap<String, Object>();
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		
		try {
			galleryDAO.insertGallery(dto);
			
			if(!mr.getFile("file").isEmpty()) {
				param = fileService.uploadFile(mr);
				
				param.put("board_id", dto.getNum());
				
				galleryDAO.insertAttach(param);
			}
			
			platformTransactionManager.commit(status);
			return 1;
		} catch (Exception e) {
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + param.get("saved_file_name"));
			delete.delete();
			platformTransactionManager.rollback(status);
			return 0;
		}
	}

	// ������ ����Ʈ ��������
	@Override
	public List<GalleryDTO> galleryList() {
		return galleryDAO.galleryList(); 
	}
	
	// ������ ��������
	@Override
	public GalleryDTO galleryContent(GalleryDTO dto) {
		return galleryDAO.galleryContent(dto);
	}
	// ��ȸ��+1
	@Override
	public void readcountUp(GalleryDTO dto) {
		 galleryDAO.readcountUp(dto);
	}

	// ������ ����
	@Override
	public int galleryModify(GalleryDTO dto) {
		return  galleryDAO.galleryModify(dto);
	}

	// ������ ����
	@Override
	public int galleryDelete(GalleryDTO dto) {
		return  galleryDAO.galleryDelete(dto);
	}
}