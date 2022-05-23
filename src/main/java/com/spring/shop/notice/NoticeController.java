package com.spring.shop.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.shop.login.dto.UserDTO;
import com.spring.shop.notice.dto.NoticeDTO;
import com.spring.shop.notice.service.DefaultNoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private DefaultNoticeService defaultNoticeService;
	
	@RequestMapping(value = "/notice" , method = RequestMethod.GET)
	public String noticehome(Model m) {
		m.addAttribute("notices", defaultNoticeService.noticeList());
		System.out.println(defaultNoticeService.noticeList());
		m.addAttribute("content", "notice.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/noticeWrite" , method = RequestMethod.GET)
	public String noticeWrite(Model m) {
		m.addAttribute("content", "noticeWrite.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/noticeWritePro" , method = RequestMethod.POST)
	public String noticeWritePro(NoticeDTO dto, Model m, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setUserId(user.getId());
		int result = defaultNoticeService.insertNotice(dto);
		if(result > 0) {
			m.addAttribute("MSG", "공지사항 작성완료");
			m.addAttribute("content", "notice.jsp");//?num="+ dto.getNum();
		}
		return "home";
	}
	
	@RequestMapping(value = "/noticeContent" , method = RequestMethod.GET)
	public String noticeContent(Model m, NoticeDTO dto) {
		dto = defaultNoticeService.noticeContent(dto); 
		// 조회수+1
		defaultNoticeService.readcountUp(dto);
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
			m.addAttribute("MSG", "공지사항 수정완료");
			m.addAttribute("content", "notice?num='dto.getNum()'.jsp");//?num="+ dto.getNum();
		}else {
			m.addAttribute("MSG", "공지사항 수정실패");
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
			m.addAttribute("MSG", "공지사항 삭제완료");
			m.addAttribute("content", "notice.jsp");
		}else {
			m.addAttribute("MSG", "공지사항 삭제실패");
			m.addAttribute("content","noticeContent?num='dto.getNum()'.jsp");
			
		}
		return "home"; 
	}
	 
}
