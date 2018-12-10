package com.chenjie.springboot.learn.service;

import com.chenjie.springboot.learn.dao.UserDao;
import com.chenjie.springboot.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"userCache"})
public class UserService {

    @Autowired
    private UserDao userDao;

    @CachePut(key = "#id")
    public User add(int id,String name,int age) {
        User user = new User(id, name, age);
        userDao.add(user);
        return user;
    }
    @CachePut(key = "#id")
    public User update(String name,int age, int id) {
        User user = new User(id, name, age);
        userDao.update(user);
        return user;
    }
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Cacheable(key = "#id")
    public User findUser(int id) {
        return userDao.findUser(id);
    }
    public List<User> findUserList() {
        return userDao.findUserList();
    }
}
