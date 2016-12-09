package com.helios.user.mapper;

import com.helios.user.bean.User;

public interface UserMapper {
	
	public User get(String username, String password) throws Exception;

	public int update(User bean) throws Exception;
}