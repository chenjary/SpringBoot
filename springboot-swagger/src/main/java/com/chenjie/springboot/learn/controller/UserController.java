package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());


    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping(value={""})
    public List<User> getUserList() {
        return new ArrayList<User>(users.values());
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @PostMapping(value="/add")
    public String postUser(@RequestBody User user) {
        try {
            users.put(user.getId(), user);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url中的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping(value="/{id}")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户", notes="根据url中的id来指定更新对象，并根据传过来的user来更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping(value="/{id}")
    public String put(@PathVariable Long id, @RequestBody User user) {
        try {
            User u = users.get(id);
            u.setName(user.getName());
            u.setAge(user.getAge());
            users.put(id, u);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url中的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @DeleteMapping(value="/{id}")
    public String delete(@PathVariable Long id) {
        try {
            users.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @GetMapping(value = "/hello")
    public String ignore() {
        return "hello";
    }

}
