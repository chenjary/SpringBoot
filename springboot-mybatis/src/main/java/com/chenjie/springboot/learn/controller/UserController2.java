package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.entity.User;
import com.chenjie.springboot.learn.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user2")
public class UserController2 {

    @Autowired
    private UserService2 userService;

    @GetMapping(value = "/list")
    public List<User> findUserList() {
        return userService.findUserList();
    }

    @GetMapping(value = "/{id}")
    public User findUser(@PathVariable("id") int id) {
        return userService.findUser(id);
    }

    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "age", required = true) int age) {
        if (0 < userService.update(name, age, id)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        if (0 < userService.delete(id)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping(value = "/add")
    public String postAccount(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
                              @RequestParam(value = "age") int age) {
        if (0 < userService.add(id, name, age)) {
            return "success";
        } else {
            return "fail";
        }
    }

}
