package com.thinking.scaffold.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionDao {

	List<String> selectPermissionByUserId(Long id);

}
