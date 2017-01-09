package com.helios.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.helios.user.bean.User;
import com.helios.user.mapper.UserMapper;

@Service
public class UserService {
	
	private static Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserMapper mapper;
	
	public User get(String username, String password){
		try {
			return mapper.get(username, DigestUtils.md5DigestAsHex(password.getBytes()));
		} catch (Exception e) {
			logger.error("登陆[用户信息]异常,原因:" + e.getMessage());
			return null;
		}
	}

	public boolean update(User bean){
		try {
			mapper.update(bean);
			return true;
		} catch (Exception e) {
			logger.error("更新[用户信息]异常,原因:" + e.getMessage());
			return false;
		}
	}
}
