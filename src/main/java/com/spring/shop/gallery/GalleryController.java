package com.spring.shop.gallery;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.gallery.dto.GalleryDTO;
import com.spring.shop.gallery.service.DefaultGalleryService;
import com.spring.shop.login.dto.UserDTO;
import com.spring.shop.notice.dto.NoticeDTO;

@Controller
public class GalleryController {
	
	@Autowired
	private DefaultGalleryService defaultGalleryService;
	
	// ������ Ȩ
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String galleryHome(Model m) {
		m.addAttribute("content", "gallery.jsp");
		return "home";
	}
	// ������ ����Ʈ
	@RequestMapping(value = "/getGalleryList" , method = RequestMethod.GET)
	@ResponseBody
	public List<GalleryDTO> getAllGalleryList(){
		return defaultGalleryService.galleryList();
	}
	
	// ������ �ۼ�
	@RequestMapping(value = "/galleryWrite", method = RequestMethod.GET)
	public String galleryWrite(Model m) {
		m.addAttribute("content", "galleryWrite.jsp");
		return "home";
	}
	
	// ������ �ۼ�Pro
	@RequestMapping(value = "/galleryWritePro" , method = RequestMethod.POST)
	public String galleryWritePro(GalleryDTO dto, Model m, HttpServletRequest req) throws IOException {
		UserDTO user = (UserDTO) req.getSession().getAttribute("loginUser");
//		dto.setUserId(user.getId());
		dto.setUserId("admin");
		int result = defaultGalleryService.insertGallery(dto, req);
		if(result > 0) {
			m.addAttribute("MSG", "������ �ۼ��Ϸ�");
		}else {
			m.addAttribute("MSG", "������ �ۼ�����");
		}
		m.addAttribute("content", "gallery.jsp");//?num="+ dto.getNum();
		return "home";
	}

	// ������ ��������
	@RequestMapping(value = "/galleryContent", method = RequestMethod.GET)
	public String galleryContent(Model m, GalleryDTO dto) {
		dto = defaultGalleryService.galleryContent(dto);
		System.out.println(dto.getSaved_file_name());
		// ��ȸ�� +1
		defaultGalleryService.readcountUp(dto);
		m.addAttribute("gallery", dto);
		m.addAttribute("content", "galleryContent.jsp");
		return "home";
	}
	
	// ������ ����
	@RequestMapping(value = "/galleryModify" , method = RequestMethod.GET)
	public String galleryModify(Model m, GalleryDTO dto) {
		dto = defaultGalleryService.galleryContent(dto); 
		m.addAttribute("gallery", dto);
		m.addAttribute("content", "noticeModify.jsp");
		return "home";
	}
	
	// ������ ���� Pro
	@RequestMapping(value = "/galleryModifyPro" , method = RequestMethod.POST)
	public String galleryModifyPro(Model m, GalleryDTO dto, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		dto.setUserId(user.getId());
		int result = defaultGalleryService.galleryModify(dto); 
		if(result > 0) {
			m.addAttribute("MSG", "������ �����Ϸ�");
			m.addAttribute("content", "gallery?num='dto.getNum()'.jsp");//?num="+ dto.getNum();
		}else {
			m.addAttribute("MSG", "������ ��������");
			m.addAttribute("content", "gallery?num='dto.getNum()'.jsp");
		}
		return "home";
	}
	
}
