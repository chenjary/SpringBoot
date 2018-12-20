package com.chenjie.springboot.learn.service;

import com.chenjie.springboot.learn.config.DS;
import com.chenjie.springboot.learn.dao.UserMapper;
import com.chenjie.springboot.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //使用数据源1查询
    @DS("datasource1")
    public List<User> findUserList1(){
        return userMapper.findUserList();
    }
    //使用数据源2查询
    @DS("datasource2")
    public List<User> findUserList2(){
        return userMapper.findUserList();
    }


    @DS("datasource1")
    public User findUser1(int id) {
        return userMapper.findUser(id);
    }
    @DS("datasource2")
    public User findUser2(int id){
        return userMapper.findUser(id);
    }

    @DS("datasource1")
    public int add1(User user){
        return userMapper.add(user);
    }
    @DS("datasource2")
    public int add2(User user){
       return userMapper.add(user);
    }
    @DS("datasource1")
    public int delete1(int id){
        return userMapper.delete(id);
    }
    @DS("datasource2")
    public int delete2(int id){
        return userMapper.delete(id);
    }
    @DS("datasource1")
    public int update1(User user){
        return userMapper.update(user);
    }
    @DS("datasource2")
    public int update2(User user){
        return userMapper.update(user);
    }
}