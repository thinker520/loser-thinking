package com.thinking.scaffold.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thinking.common.CommonResult;
import org.thinking.common.StringUtil;

import com.thinking.scaffold.controller.form.LoginUserInfo;
import com.thinking.scaffold.util.IPUtil;

@Controller
public class LoginController extends BaseController{

	@RequestMapping("/passport/user/login")
	@ResponseBody
	public CommonResult<?> login(HttpServletRequest request, Model model) {
		LoginUserInfo loginUser = getLoginUser(request);
		if(null != loginUser) {
			System.out.println("user is logining ");
			return CommonResult.success();
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
        try {
        	String code = request.getParameter("vercode");
    		if(StringUtil.isNullOrBlank(username)) {
    			return CommonResult.fail("用户名不能为空");
    		}
    		if(StringUtil.isNullOrBlank(password)) {
    			return CommonResult.fail("用户名密码不能为空");
    		}
    		if(StringUtil.isNullOrBlank(code)) {
    			return CommonResult.fail("验证码不能为空");
    		}
    		Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
            user.login(token);
            loginUser = new LoginUserInfo();
    		loginUser.setId(1);
    		loginUser.setUsername(username);
    		loginUser.setIp(IPUtil.getIp(request));
    		saveLoginUser(request, loginUser);//直接存储到SESSION
    		//TODO 校验
    		return CommonResult.success(loginUser);
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            model.addAttribute("message", "账号不存在！");
            return CommonResult.fail("账号不存在！");
        } catch (DisabledAccountException e) {
            model.addAttribute("message", "账号未启用！");
            return CommonResult.fail("账号未启用！");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message", "密码错误！");
            return CommonResult.fail("密码错误！");
        } catch (Throwable e) {
            model.addAttribute("message", "未知错误！");
            return CommonResult.fail("未知错误！");
        }
	}
}
