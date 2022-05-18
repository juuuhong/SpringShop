package com.spring.shop.signUpPro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpProController {

	@RequestMapping(value = "/signUpPro" , method = RequestMethod.GET)
	public String galleryHome(Model m) {
		m.addAttribute("content","signUpPro.jsp");
		return "home";
	}
}
