package com.thinking.scaffold.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thinking.common.CommonResult;
import org.thinking.common.StringUtil;

import com.thinking.scaffold.model.User;
import com.thinking.scaffold.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/list")
    @ResponseBody
    public CommonResult<?> list(@RequestParam(defaultValue = "30") Integer limit,
    		@RequestParam(defaultValue = "1") Integer page) {
    	return CommonResult.success(userService.selectUsers(page, limit));
    }
    
    @RequestMapping("/add")
    @ResponseBody
    public CommonResult<?> add(User u) {
    	try {
    		if(StringUtil.isNullOrBlank(u.getUserName())) {
    			return CommonResult.fail("用户名不能为空");
    		}
    		if(StringUtil.isNullOrBlank(u.getPassword())) {
    			return CommonResult.fail("密码不能为空");
    		}
    		if(StringUtil.isNullOrBlank(u.getRepassword())) {
    			return CommonResult.fail("确认密码不能为空");
    		}
    		if(!u.getPassword().equals(u.getRepassword())) {
    			return CommonResult.fail("两次密码不一致");
    		}
    		boolean isExist = userService.checkExist(u.getUserName());
    		if(isExist) {
    			return CommonResult.fail("该登录账号已存在");
    		}
    		//密码需要进行加密存储
    		int ret = userService.insert(u);
    		if(ret > 0) {
    			return CommonResult.success();
    		} 
    		return CommonResult.fail("添加失败");
    	} catch(Exception ex) {
    		ex.printStackTrace();
    		return CommonResult.fail("系统异常");
    	}
    }
}
