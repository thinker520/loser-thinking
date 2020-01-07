package com.delivery.schedules;

import java.util.Date;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.delivery.entity.User;
import com.delivery.entity.UserType;
import com.delivery.service.UserService;
import com.delivery.utils.RandomValue;
import com.delivery.utils.UserUtil;

public class UserCreateTask implements Callable<User>{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private UserService userService;
	
	public UserCreateTask(UserService userService) {
		this.userService = userService;
		Thread.currentThread().setName("create user thead:" + System.currentTimeMillis());
	}



	@Override
	public User call() throws Exception {
		logger.info("roboot generate user start");
		User u = new User();
		u.setAccount(UserUtil.getStringRandom(12));
		u.setPassword("123456");
		u.setNickname(UserUtil.randomChineseNickName(true, 6));
		u.setSalt("88");
		u.setUserType(UserType.MEMBERSHIP);
		u.setRealname(RandomValue.getChineseName());
		u.setPhone(RandomValue.getTel());
		u.setEmail(RandomValue.getEmail(6, 12));
		u.setUpdateTime(new Date());
		u.setCreateTime(new Date());
		u.setAddress(RandomValue.getRoad());
		u.setSex(RandomValue.getName_sex());
		User user = userService.save(u);
		if(null != user) {
			logger.info("save success");
		} else {
			logger.info("save fail");
		}
		logger.info("roboot generate user end");
		return user;
	}

}
