package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.entity.User;
import com.chenjie.springboot.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<User> findUserList() {
        return userService.findUserList1();
    }

    @GetMapping(value = "/{id}")
    public User findUser(@PathVariable("id") int id) {
        return userService.findUser1(id);
    }

    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "age", required = true) int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        if (0 < userService.update1(user)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        if (0 < userService.delete1(id)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping(value = "/add")
    public String postAccount(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
                              @RequestParam(value = "age") int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        if (0 < userService.add1(user)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping(value = "/db2/list")
    public List<User> findUserList2() {
        return userService.findUserList2();
    }

    @GetMapping(value = "/db2/{id}")
    public User findUser2(@PathVariable("id") int id) {
        return userService.findUser2(id);
    }

    @PutMapping(value = "/db2/{id}")
    public String updateAccount2(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "age", required = true) int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        if (0 < userService.update2(user)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @DeleteMapping(value = "/db2/{id}")
    public String delete2(@PathVariable(value = "id") int id) {
        if (0 < userService.delete2(id)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping(value = "/db2/add")
    public String postAccount2(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
                              @RequestParam(value = "age") int age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        if (0 < userService.add2(user)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
