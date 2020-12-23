package com.cn.one.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.one.entity.Status;
import com.cn.one.entity.User;
import com.cn.one.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	// 登录验证
	@RequestMapping("/checkUsername")
	@ResponseBody
	public Status check(User user, ModelMap modelMap, HttpSession session) {
		// System.out.println(">>>>>进来了,User:"+user+"<>Session:"+session.getAttribute("VerificationCode"));
		String verify = session.getAttribute("VerificationCode").toString();
		User data = userService.findByName(user.getUsername());// 验证用户是否存在
		Status result = new Status();
		if (data != null) {
			if (user.getPassword().equals(data.getPassword())) {// 验证密码
				if (verify.equals(user.getVerify())) {
					result.setCode(Status.SUCCESS);
					result.setMessage(Status.SUCCMSG);
					System.out.println(result.toString());
					return result;
				}
				result.setCode(Status.CODEERR);
				result.setMessage(Status.CODEERRMSG);
				System.out.println(result.toString());
				return result;
			}
			result.setCode(Status.PWDERR);
			result.setMessage(Status.PWDERRMSG);
			System.out.println(result.toString());
			return result;
		}
		result.setCode(Status.USERNOTERR);
		result.setMessage(Status.USERNOTERRMSG);
		System.out.println("check>>>" + result.toString());
		return result;
	}

	// 跳转到主页
	@RequestMapping("/toHome")
	public String toHome(User user, Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		home(model);
		return "home";
//		return "layout/layout";
	}

	/*
	 * 将数据存储在model中发给前端
	 */
	public void home(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
	}
}
