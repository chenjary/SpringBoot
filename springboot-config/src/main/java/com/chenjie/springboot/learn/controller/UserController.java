package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    User user;

    @RequestMapping(value = "/user")
    public String user() {
        return user.getName() + ":" + user.getAge();
    }

}
