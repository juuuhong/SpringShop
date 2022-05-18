package com.spring.shop.login.service;

import com.spring.shop.login.dto.UserDTO;

public interface UserService {
	
	int insertUser(UserDTO dto);
	UserDTO login(UserDTO dto);
	
}
