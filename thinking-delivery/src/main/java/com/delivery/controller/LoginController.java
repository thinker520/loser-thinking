package com.delivery.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thinking.common.CommonResult;

@Controller
@RequestMapping("/uc")
public class LoginController {

	@RequestMapping("/login")
	@ResponseBody
	public CommonResult<?> login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		return CommonResult.success();
	}
	
}
