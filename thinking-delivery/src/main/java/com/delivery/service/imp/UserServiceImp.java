package com.delivery.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.dao.UserDao;
import com.delivery.entity.User;
import com.delivery.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public User save(User u) {
		return userDao.save(u);
	}

}
