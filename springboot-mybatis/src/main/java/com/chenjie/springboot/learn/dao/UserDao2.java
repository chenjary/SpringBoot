package com.chenjie.springboot.learn.dao;

import com.chenjie.springboot.learn.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao2 {
    int add(User user);

    int update(User user);

    int delete(int id);

    User findUser(@Param("id") int id);

    List<User> findUserList();
}

