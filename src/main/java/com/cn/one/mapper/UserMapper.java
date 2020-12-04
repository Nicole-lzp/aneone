package com.cn.one.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.one.entity.User;

public interface UserMapper {

	@Select("select username, password from user where username=#{username}")
	public User findByName(String username);
	
	@Select("select id, username, password from user where id=#{id}")
	public User findById(Integer id);

	@Select("select * from user")
	public List<User> findAll();
	
	@Insert("insert into user(username, password) values(#{username}, #{password})")
	public int insert(User user);
	
	@Delete("delete from user where id=#{id}")
	public int delete(Integer id);
	
	@Update("update user set username=#{username}, password=#{password} where id=#{id}")
	public int update(User user);
}
