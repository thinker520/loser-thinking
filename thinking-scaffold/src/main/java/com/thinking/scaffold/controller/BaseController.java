package com.thinking.scaffold.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.thinking.scaffold.controller.form.LoginUserInfo;

public class BaseController {
	
	public static final String LOGIN_USER_KEY = "LOGIN_USER";
	
	protected LoginUserInfo getLoginUser(HttpServletRequest request) {
		LoginUserInfo user = (LoginUserInfo) request.getSession().getAttribute(LOGIN_USER_KEY);
		return user;
	}
	
	protected void saveLoginUser(HttpServletRequest request, LoginUserInfo user) {
		HttpSession session = request.getSession();
		if(null != session) {
			session.setAttribute(LOGIN_USER_KEY, user);
		}
	}
}
