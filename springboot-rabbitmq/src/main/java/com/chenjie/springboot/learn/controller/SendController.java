package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SendController {

    @Autowired
    private SendService sendService;

    @GetMapping("/send/{message}")
    public String send(@PathVariable String message){
        String uuid = UUID.randomUUID().toString();
        sendService.send(uuid,message);
        return uuid;
    }
}
