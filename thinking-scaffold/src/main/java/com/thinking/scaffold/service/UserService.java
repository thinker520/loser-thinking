package com.thinking.scaffold.service;

import java.util.List;

import com.thinking.scaffold.model.User;

public interface UserService {
	
	int insert(User user);

	void deleteUserById(Long userId);

	void updateUser(User user);

	List<User> selectUsers(Integer page, Integer limit);

	User findByUserName(String username);

	boolean checkExist(String userName);
}
