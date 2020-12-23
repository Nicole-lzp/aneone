package com.cn.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.one.entity.User;
import com.cn.one.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private LoginController loginController;

	@RequestMapping("/user/add")
	public String add() {
		return "user/insert";
	}
	
	@RequestMapping("/user/infos")
	public String userinfo(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/userinfo";
	}
	
	
	@RequestMapping("/insert")
	public String insert(User user, Model model) {
		int count = userService.insert(user);
		if(count==1) {
			loginController.home(model);
			return "home";
		}
		return "login";
	}
	
	/*
	 * 	删除
	 *	@PathVariable("xxx")
	 * 	通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“) 
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		int count = userService.delete(id);
		if(count==1) {
			loginController.home(model);
			return "home";
		}
		return "login";
	}
	
	@RequestMapping("/toUpdate/{id}")
	public String ToUpdate(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping("/update")
	public String update(User user, Model model) {
		int count = userService.update(user);
		if(count == 1) {
			loginController.home(model);
			return "home";
		}
		return "login";
	}
}
