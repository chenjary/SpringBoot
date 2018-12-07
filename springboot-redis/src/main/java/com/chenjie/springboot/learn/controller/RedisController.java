package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.entity.RedisEntity;
import com.chenjie.springboot.learn.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {
    @Autowired
    private RedisServiceImpl service;

    //添加
    @GetMapping(value = "/add")
    public String add() {
        try {
            RedisEntity m = new RedisEntity();
            m.setName("chenjay");
            m.setTel("13800001111");
            m.setAddress("cd");
            m.setRedisKey("chenjay");
            service.put(m.getRedisKey(), m, -1);

            RedisEntity m2 = new RedisEntity();
            m2.setName("mary");
            m2.setTel("13011115555");
            m2.setAddress("sz");
            m2.setRedisKey("mary");
            service.put(m2.getRedisKey(), m2, -1);

            RedisEntity m3 = new RedisEntity();
            m3.setName("lucy");
            m3.setTel("13688889999");
            m3.setAddress("sh");
            m3.setRedisKey("lucy");
            service.put(m3.getRedisKey(), m3, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    //查询所有对象
    @GetMapping(value = "/list")
    public Object getAll() {
        return service.getAll();
    }

    //查询所有key
    @GetMapping(value = "/keys")
    public Object getKeys() {
        return service.getKeys();
    }

    //根据key查询
    @GetMapping(value = "/{key}")
    public Object get(@PathVariable String key) {
        return service.get(key);
    }

    //删除
    @GetMapping(value = "/remove/{key}")
    public String remove(@PathVariable String key) {
        try {
            service.remove(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    //判断key是否存在
    @GetMapping(value = "/isExist/{key}")
    public Object isKeyExists(@PathVariable String key) {
        return service.isKeyExists(key);
    }

    //查询当前缓存的数量
    @GetMapping(value = "/count")
    public Object count() {
        return service.count();
    }

    //清空所有key
    @GetMapping(value = "/empty")
    public String empty() {
        try {
            service.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
