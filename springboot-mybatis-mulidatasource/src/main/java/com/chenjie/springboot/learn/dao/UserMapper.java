package com.chenjie.springboot.learn.dao;

import com.chenjie.springboot.learn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int add(User user);

    int update(User user);

    int delete(int id);

    User findUser(@Param("id") int id);

    List<User> findUserList();
}
