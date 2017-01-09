package com.helios.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.helios.user.bean.User;

@Mapper
@Service
public interface UserMapper {
	
	public User get(String username, String password);
    
	public int update(User bean);
}