package com.cn.one.controllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cn.one.controller.UserController;
import com.cn.one.entity.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

	@Autowired
	private UserController userController;
	
	@Test
	public void save() {
		User user = new User("lisi","123123","");
		userController.insert(user, null);
		System.out.println("测试结束");
	}
}
