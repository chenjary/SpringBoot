package com.chenjie.springboot.learn.dao;

import com.chenjie.springboot.learn.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Insert("insert into user(id, name, age) values(#{id}, #{name}, #{age})")
    int add(@Param("id") int id, @Param("name") String name, @Param("age") int age);

    @Update("update user set name = #{name}, age = #{age} where id = #{id}")
    int update(@Param("name") String name, @Param("age") int age, @Param("id") int id);

    @Delete("delete from user where id = #{id}")
    int delete(int id);

    @Select("select id, name, age from user where id = #{id}")
    User findUser(@Param("id") int id);

    @Select("select id, name, age from user")
    List<User> findUserList();
}

