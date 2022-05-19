package com.spring.shop.login.dao;

import com.spring.shop.login.dto.UserDTO;

public interface UserMapper {
	
	int insertUser(UserDTO dto);
	UserDTO login(UserDTO dto);
	int userUpdate(UserDTO dto);
	int pwChange(UserDTO dto);
	int deleteUser(UserDTO dto);
}
