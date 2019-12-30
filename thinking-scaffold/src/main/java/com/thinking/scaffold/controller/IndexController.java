package com.thinking.scaffold.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinking.scaffold.controller.form.LoginUserInfo;

@Controller
public class IndexController extends BaseController{

	@RequestMapping("")
	public String index(HttpServletRequest request) {
		LoginUserInfo user = getLoginUser(request);
		if(null == user) {
			return "login";
		}
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		LoginUserInfo user = getLoginUser(request);
		if(null != user) {
			return "";
		}
		return "register";
	}
	
	@RequestMapping("/forget")
	public String forget() {
		return "forget";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "redirect:/";
	}
	

}
