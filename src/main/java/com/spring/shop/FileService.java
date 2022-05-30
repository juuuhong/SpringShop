package com.spring.shop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class FileService {
	/**
	 * 
	 * 단일 파일 업로드
	 * 
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> uploadFile(MultipartHttpServletRequest mr) throws IOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String path = mr.getSession().getServletContext().getRealPath("resources/file");
		
		File saveDir = new File(path);
		
		// 폴더만들기..ㅋ
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		MultipartFile file = mr.getFile("file");
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(path);
		
		String originalName = file.getOriginalFilename();
		long file_size = file.getSize();
		
		
		File destination = File.createTempFile("F_"+System.currentTimeMillis(), originalName.substring(originalName.lastIndexOf(".")), saveDir);
		System.out.println(destination.getName());
		
		String saved_file_name = destination.getName();
		
		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destination));
		
		param.put("file_name", originalName);
		param.put("file_size", file_size);
		param.put("saved_file_name", saved_file_name);
		
		return param;
	}
	
}
