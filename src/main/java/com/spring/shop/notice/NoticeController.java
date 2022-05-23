package com.spring.shop.notice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.shop.login.dto.UserDTO;
import com.spring.shop.notice.dto.NoticeDTO;
import com.spring.shop.notice.service.DefaultNoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private DefaultNoticeService defaultNoticeService;
	
	@RequestMapping(value = "/notice" , method = RequestMethod.GET)
	public String noticehome(Model m) {
		m.addAttribute("content", "notice.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/getNoticeList" , method = RequestMethod.GET)
	@ResponseBody
	public List<NoticeDTO> getAllNoticeList() {
		return defaultNoticeService.noticeList();
	}
	
	@RequestMapping(value = "/noticeWrite" , method = RequestMethod.GET)
	public String noticeWrite(Model m) {
		m.addAttribute("content", "noticeWrite.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/noticeWritePro" , method = RequestMethod.POST)
	public String noticeWritePro(NoticeDTO dto, Model m, HttpServletRequest req) throws IOException {
		UserDTO user = (UserDTO) req.getSession().getAttribute("loginUser");
//		dto.setUserId(user.getId());
		dto.setUserId("admin");
		int result = defaultNoticeService.insertNotice(dto, req);
		if(result > 0) {
			m.addAttribute("MSG", "�������� �ۼ��Ϸ�");
		}else {
			m.addAttribute("MSG", "�������� �ۼ�����");
			
		}
		m.addAttribute("content", "notice.jsp");//?num="+ dto.getNum();
		return "home";
	}
	
	@RequestMapping(value = "/noticeContent" , method = RequestMethod.GET)
	public String noticeContent(Model m, NoticeDTO dto) {
		dto = defaultNoticeService.noticeContent(dto); 
		// ��ȸ��+1
		defaultNoticeService.readcountUp(dto);
		
		System.out.println(defaultNoticeService.getFile(dto));
		
		m.addAttribute("file", defaultNoticeService.getFile(dto));
		m.addAttribute("notice", dto);
		m.addAttribute("content", "noticeContent.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/noticeModify" , method = RequestMethod.GET)
	public String noticeModify(Model m, NoticeDTO dto) {
		dto = defaultNoticeService.noticeContent(dto); 
		m.addAttribute("notice", dto);
		m.addAttribute("content", "noticeModify.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/noticeModifyPro" , method = RequestMethod.POST)
	public String noticeModifyPro(Model m, NoticeDTO dto, HttpSession session) {
		System.out.println(dto.getContent());
		System.out.println(dto.getTitle());
		System.out.println(dto.getNum());
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setUserId(user.getId());
		int result = defaultNoticeService.noticeModify(dto); 
		if(result > 0) {
			m.addAttribute("MSG", "�������� �����Ϸ�");
			m.addAttribute("content", "notice?num='dto.getNum()'.jsp");//?num="+ dto.getNum();
		}else {
			m.addAttribute("MSG", "�������� ��������");
			m.addAttribute("content", "notice?num='dto.getNum()'.jsp");
		}
		return "home";
	}
	
	@RequestMapping(value = "/noticeDelete" , method = RequestMethod.GET)
	public String noticeDelete(Model m, NoticeDTO dto, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setUserId(user.getId());
		int result = defaultNoticeService.noticeDelete(dto);
		if(result > 0) {
			m.addAttribute("MSG", "�������� �����Ϸ�");
			m.addAttribute("content", "notice.jsp");
		}else {
			m.addAttribute("MSG", "�������� ��������");
			m.addAttribute("content","noticeContent?num='dto.getNum()'.jsp");
			
		}
		return "home"; 
	}
	 
}
