package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/rollback")
    public String rollback() {
        try {
            userService.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rollback";
    }

    @GetMapping(value = "/withoutRollback")
    public String withoutRollback() {
        try {
            userService.withoutRollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "withoutRollback";
    }

}
