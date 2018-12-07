package com.chenjie.springboot.learn.service;

import com.chenjie.springboot.learn.dao.UserDao;
import com.chenjie.springboot.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void rollback() throws Exception {
        User user = userDao.findUser(1);
        ddAge(user);
        User user1 = userDao.findUser(3);
        ddAge(user1);

        userDao.update(user);
        int i = 1 / 0;
        userDao.update(user1);
    }


    public void withoutRollback() throws Exception {
        User user = userDao.findUser(1);
        ddAge(user);
        User user1 = userDao.findUser(3);
        ddAge(user1);

        userDao.update(user);
        int i = 1 / 0;
        userDao.update(user1);
    }

    private void ddAge(User user) {
        user.setAge(user.getAge() + 1);
    }

}
