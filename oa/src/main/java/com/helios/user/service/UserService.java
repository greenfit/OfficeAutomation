package com.helios.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helios.user.bean.User;
import com.helios.user.mapper.UserMapper;

@Service
public class UserService {

	private static Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserMapper mapper;
	
	public User get(String username, String password){
		try {
			return mapper.get(username, password);
		} catch (Exception e) {
			logger.error("登陆[管理员信息]异常,原因:" + e.getMessage());
			return null;
		}
	}

	public boolean update(User bean){
		try {
			mapper.update(bean);
			return true;
		} catch (Exception e) {
			logger.error("更新[管理员信息]异常,原因:" + e.getMessage());
			return false;
		}
	}
}
