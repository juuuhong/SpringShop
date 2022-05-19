package com.spring.shop.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.login.dao.UserDAO;
import com.spring.shop.login.dto.UserDTO;

@Service
public class DefaultUserService implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public int insertUser(UserDTO dto) {
		dto.setPreAddr(dto.getPreAddr() + "!" + dto.getSufAddr());
		return userDAO.insertUser(dto);
	}

	@Override
	public UserDTO login(UserDTO dto) {
		return userDAO.login(dto);
	}

	@Override
	public int userUpdate(UserDTO dto) {
		dto.setPreAddr(dto.getPreAddr() + "!" + dto.getSufAddr());
		return userDAO.userUpdate(dto);
	}

	@Override
	public int pwChange(UserDTO dto) {
		return userDAO.pwChange(dto);
	}

	@Override
	public int deleteUser(UserDTO dto) {
		return userDAO.deleteUser(dto);
	}

}
