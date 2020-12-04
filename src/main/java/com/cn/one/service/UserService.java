package com.cn.one.service;

import java.util.List;

import com.cn.one.entity.User;

public interface UserService {
	
	public User findByName(String username);
	
	public User findById(Integer id);
	
	public List<User> findAll();

	public int insert(User user);
	
	public int delete(Integer id);
	
	public int update(User user);
}
