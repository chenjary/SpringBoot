package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/chenjay")
    public String Chenjay() {
        return configBean.getGreeting() + " >>>>" + configBean.getValue() + " >>>>" + configBean.getUuid() + " >>>>" + configBean.getMax();
    }
}
