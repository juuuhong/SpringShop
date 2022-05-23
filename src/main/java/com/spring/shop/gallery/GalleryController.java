package com.spring.shop.gallery;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GalleryController {
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String galleryHome(Model m) {
		m.addAttribute("content", "gallery.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/galleryWrite", method = RequestMethod.GET)
	public String galleryWrite(Model m) {
		m.addAttribute("content", "galleryWrite.jsp");
		return "home";
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/resources/image", method = RequestMethod.POST)
	 * public Map<String, Object> uploadImage(@RequestParam Map<String, Object>
	 * paramMap, MultipartRequest request) throws Exception { MultipartFile
	 * uploadFile = request.getFile("upload"); String uploadDir =
	 * servletContext.getRealPath("/").replace("\\", "/") + "/resources/image";
	 * String uploadId = UUID.randomUUID().toString() + "." +
	 * FilenameUtils.getExtension(uploadFile.getOriginalFilename());
	 * uploadFile.transferTo(new File(uploadDir + uploadId)); paramMap.put("url",
	 * "/resources/image" + uploadId); return paramMap; }
	 */
	/*
	 * @Value("#{props['editor.img.save.url']}") private String saveUrl;
	 * 
	 * @Value("#{props['editor.img.load.url']}") private String loadUrl;
	 * 
	 * @Value("#{props['editor.mode']}") private String mode;
	 * 
	 * @RequestMapping(value="/resources/image") public ModelAndView
	 * image(@RequestParam Map<String, Object> map, MultipartHttpServletRequest
	 * request) throws Exception{ ModelAndView mv = new ModelAndView("jsonView");
	 * 
	 * List<MultipartFile> fileList = request.getFiles("upload");
	 * 
	 * String imgPath = null;
	 * 
	 * for (MultipartFile mf : fileList) { if (fileList.get(0).getSize() > 0) {
	 * String originFileName = mf.getOriginalFilename(); // 원본 파일 명 String ext =
	 * FilenameUtils.getExtension(originFileName); String newInfImgFileName = "img_"
	 * + UUID.randomUUID() + "." + ext;
	 * 
	 * imgPath = loadUrl + newInfImgFileName;
	 * 
	 * File file = new File(saveUrl + newInfImgFileName);
	 * 
	 * mf.transferTo(file);
	 * 
	 * if(!"local".equals(mode)) { Runtime.getRuntime().exec("chmod 666 " + file); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * mv.addObject("uploaded", true); mv.addObject("url", imgPath); return mv; }
	 */

}
