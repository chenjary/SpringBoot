package com.chenjie.springboot.learn.dao;

import com.chenjie.springboot.learn.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Update("update user set age = #{age} where id = #{id}")
    int update(User user);

    @Select("select id, name, age from user where id = #{id}")
    User findUser(@Param("id") int id);
}

