package com.thinking.scaffold.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinking.scaffold.dao.UserDao;
import com.thinking.scaffold.model.User;
import com.thinking.scaffold.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDao userDao;//这里会爆红，请忽略

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User userDomain) {
        userDao.updateUser(userDomain);
    }

    @Override
    public List<User> selectUsers(Integer page, Integer limit) {
        return userDao.selectUsers(page, limit);
    }

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean checkExist(String username) {
		User u = userDao.findByUserName(username);
		return null != u;
	}
}
