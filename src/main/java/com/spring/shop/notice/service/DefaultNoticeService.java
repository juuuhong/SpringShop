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
			// isEmpty : ����ִ�? !�޾Ƽ� �ݴ�
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
		// isEmpty : ����ִ�? !�޾Ƽ� �ݴ� == ���ϵ���־�
		if(!mr.getFile("file").isEmpty()) {
			// ���������� �����ؾ���+������̺� �����ع��� �׳�.. ������Ʈ��������
			noticeDAO.deleteFile(dto);
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + saved_file_name);
			delete.delete();
			// ���ο� ������ ������@!
			param = fileService.uploadFile(mr);
			param.put("board_id", dto.getNum());
			
			noticeDAO.insertAttach(param);
		}else if(mr.getParameter("exPhoto").equals("null") || mr.getParameter("exPhoto").equals("")){
			// ���ϵ� ���� ������ ��������������� ���� ���� ��������
			noticeDAO.deleteFile(dto);
			File delete = new File(req.getSession().getServletContext().getRealPath("resources/file/") + saved_file_name);
			delete.delete();
		}else {
			// �����߰� ���� ���������� �״�θ� �������� �״�� �����ϴµ� �׳� ���θ�Ǵ°žƴѰ�
			//dto.setUser_img(mr.getParameter("exPhoto"));// ����db����� �̸����� �ٽ� dto�߰�
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