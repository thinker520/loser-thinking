package com.thinking.scaffold.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinking.scaffold.dao.PermissionDao;
import com.thinking.scaffold.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	PermissionDao permissionDao;
	
	@Override
	public List<String> selectPermissionByUserId(Long id) {
		return permissionDao.selectPermissionByUserId(id);
	}

}
