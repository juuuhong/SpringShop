package com.spring.shop.login.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.login.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// ȸ������
	public int insertUser(UserDTO dto) {
		return sqlSession.getMapper(UserMapper.class).inserUser(dto);
	}
	
	//�α���
	public UserDTO login(UserDTO dto) {
		return sqlSession.getMapper(UserMapper.class).login(dto);
	}
}
