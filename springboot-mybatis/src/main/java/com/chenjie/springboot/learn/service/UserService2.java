package com.chenjie.springboot.learn.service;

import com.chenjie.springboot.learn.dao.UserDao2;
import com.chenjie.springboot.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService2 {

    @Autowired
    private UserDao2 userDao;

    public int add(int id,String name,int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userDao.add(user);
    }
    public int update(String name,int age, int id) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userDao.update(user);
    }
    public int delete(int id) {
        return userDao.delete(id);
    }
    public User findUser(int id) {
        return userDao.findUser(id);
    }
    public List<User> findUserList() {
        return userDao.findUserList();
    }
}
