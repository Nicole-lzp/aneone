package com.cn.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.one.entity.User;
import com.cn.one.mapper.UserMapper;
import com.cn.one.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(User user) {
		int count = userMapper.insert(user);
		return count;
	}

	@Override
	public User findByName(String username) {
		User user = userMapper.findByName(username);
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = userMapper.findAll();
		return users;
	}

	@Override
	public int delete(Integer id) {
		int count = userMapper.delete(id);
		return count;
	}

	@Override
	public User findById(Integer id) {
		User user = userMapper.findById(id);
		return user;
	}

	@Override
	public int update(User user) {
		int count = userMapper.update(user);
		return count;
	}

}
