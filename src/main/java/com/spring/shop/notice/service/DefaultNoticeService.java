package com.spring.shop.notice.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Destination;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.FileService;
import com.spring.shop.notice.dao.NoticeDAO;
import com.spring.shop.notice.dto.NoticeDTO;

@Service
public class DefaultNoticeService implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Override
	public List<NoticeDTO> noticeList() {
		return noticeDAO.noticeList();
	}

	@Override
	public int insertNotice(NoticeDTO dto, HttpServletRequest req) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		Map<String, Object> param = new HashMap<String, Object>();
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		
		try {
			noticeDAO.insertNotice(dto);
			// isEmpty : 비어있니? !달아서 반대
			if(!mr.getFile("file").isEmpty()) {
				param = fileService.uploadFile(mr);
				
				param.put("board_id", dto.getNum());
				
				noticeDAO.insertAttach(param);
			}
			
			platformTransactionManager.commit(status);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + param.get("saved_file_name"));
			delete.delete();
			platformTransactionManager.rollback(status);
			return 0;
		}
	}

	@Override
	public NoticeDTO noticeContent(NoticeDTO dto) {
		return noticeDAO.noticeContent(dto);
	}
	
	@Override
	public String getFile(NoticeDTO dto) {
		return noticeDAO.getFile(dto);
	}

	@Override
	public void readcountUp(NoticeDTO dto) {
		noticeDAO.readcountUp(dto);
		
	}

	@Override
	public int noticeModify(NoticeDTO dto, HttpServletRequest req) throws IOException {
		String saved_file_name = noticeDAO.getFile(dto);
		Map<String, Object> param = new HashMap<String, Object>();
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;

		noticeDAO.noticeModify(dto);
		// isEmpty : 비어있니? !달아서 반대 == 파일들어있엉
		if(!mr.getFile("file").isEmpty()) {
			// 기존사진을 삭제해야해+디비테이블도 삭제해버려 그냥.. 업데이트하지말자
			noticeDAO.deleteFile(dto);
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + saved_file_name);
			delete.delete();
			// 새로운 사진을 저장해@!
			param = fileService.uploadFile(mr);
			param.put("board_id", dto.getNum());
			
			noticeDAO.insertAttach(param);
		}else if(mr.getParameter("exPhoto").equals("null") || mr.getParameter("exPhoto").equals("")){
			// 파일도 없고 기존에 사진삭제했을경우 기존 파일 삭제하자
			noticeDAO.deleteFile(dto);
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + saved_file_name);
			delete.delete();
		}else {
			// 파일추가 없고 기존파일은 그대로면 기존파일 그대로 저장하는데 그냥 냅두면되는거아닌가
			//dto.setUser_img(mr.getParameter("exPhoto"));// 기존db저장된 이름으로 다시 dto추가
		}
			
		return noticeDAO.noticeModify(dto);
	}

	@Override
	public int noticeDelete(NoticeDTO dto, HttpServletRequest req) {
		String saved_file_name = noticeDAO.getFile(dto);
		if(noticeDAO.noticeDelete(dto) == 1) {
			noticeDAO.deleteFile(dto);
			
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + saved_file_name);
			delete.delete();
			return 1;
		}else {
			return 0;
		}
	}


}