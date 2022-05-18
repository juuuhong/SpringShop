package com.spring.shop.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {
	
	@RequestMapping(value = "/notice" , method = RequestMethod.GET)
	public String noticehome(Model m) {
		m.addAttribute("content", "notice.jsp");
		return "home";
	}

}
