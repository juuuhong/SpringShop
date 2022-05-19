package com.spring.shop.notice;

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
	public String noticeContent(Model m) {
		m.addAttribute("content", "noticeContent.jsp");
		return "home";
	}
}
