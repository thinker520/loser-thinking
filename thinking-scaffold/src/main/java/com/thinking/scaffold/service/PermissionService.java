package com.thinking.scaffold.service;

import java.util.List;

public interface PermissionService {

	List<String> selectPermissionByUserId(Long id);

}
