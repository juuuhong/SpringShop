package com.spring.shop.gallery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	
	@RequestMapping(value = "/gallery" , method = RequestMethod.GET)
	public String galleryHome(Model m) {
		m.addAttribute("content","gallery.jsp");
		return "home";
	}

}
