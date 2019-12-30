package com.thinking.scaffold.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.thinking.scaffold.model.User;

@Mapper
public interface UserDao {

	int insert(User user);

    void deleteUserById(@Param("userId") Long id);

    void updateUser(User user);

    List<User> selectUsers(@Param("page") Integer page, @Param("limit") Integer limit);

	User findByUserName(@Param("userName") String username);
}
