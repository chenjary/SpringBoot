package com.chenjie.springboot.learn.controller;

import com.chenjie.springboot.learn.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.WatchService;

@RestController
public class WebSocketSendMessageController {
    @Autowired
    private WebSocketService socketService;
    @GetMapping("/send")
    public String sendMessage(){
        try {
            socketService.sendInfo("大家好");
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succcess";
    }
}