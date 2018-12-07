package com.chenjie.springboot.learn.service;

import com.chenjie.springboot.learn.dao.UserDao;
import com.chenjie.springboot.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int add(int id,String name,int age) {
        return userDao.add(id, name, age);
    }
    public int update(String name,int age, int id) {
        return userDao.update(name, age, id);
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
