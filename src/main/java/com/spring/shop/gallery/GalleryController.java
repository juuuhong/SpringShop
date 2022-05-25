package com.spring.shop.gallery;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.gallery.dto.GalleryDTO;
import com.spring.shop.gallery.service.DefaultGalleryService;
import com.spring.shop.login.dto.UserDTO;

@Controller
public class GalleryController {
	
	@Autowired
	private DefaultGalleryService defaultGalleryService;
	
	// 갤러리 홈
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String galleryHome(Model m) {
		m.addAttribute("content", "gallery.jsp");
		return "home";
	}
	// 갤러리 리스트
	@RequestMapping(value = "/getGalleryList" , method = RequestMethod.GET)
	@ResponseBody
	public List<GalleryDTO> getAllGalleryList(){
		return defaultGalleryService.galleryList();
	}
	
	// 갤러리 작성
	@RequestMapping(value = "/galleryWrite", method = RequestMethod.GET)
	public String galleryWrite(Model m) {
		m.addAttribute("content", "galleryWrite.jsp");
		return "home";
	}
	
	// 갤러리 작성Pro
	@RequestMapping(value = "/galleryWritePro" , method = RequestMethod.POST)
	public String galleryWritePro(GalleryDTO dto, Model m, HttpServletRequest req) throws IOException {
		UserDTO user = (UserDTO) req.getSession().getAttribute("loginUser");
//		dto.setUserId(user.getId());
		dto.setUserId("admin");
		int result = defaultGalleryService.insertGallery(dto, req);
		if(result > 0) {
			m.addAttribute("MSG", "갤러리 작성완료");
		}else {
			m.addAttribute("MSG", "갤러리 작성실패");
		}
		m.addAttribute("content", "gallery.jsp");//?num="+ dto.getNum();
		return "home";
	}

}
