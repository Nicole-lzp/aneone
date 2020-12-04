package com.cn.one.mapperTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cn.one.entity.User;
import com.cn.one.mapper.UserMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersTest {

	@Autowired
	private UserMapper usersMapper;
	
	@Test
	public void testSave() {
		User users = new User("zhangsna","123456","");
		int count = usersMapper.insert(users);
		System.out.println("count:"+count);
		
	}
	
	@Test
	public void testFindAll() {
		System.out.println("testFindAll start...");
		List<User> users = usersMapper.findAll();
		System.out.println("testFindAdd end users:"+users.toString());
	}
}
