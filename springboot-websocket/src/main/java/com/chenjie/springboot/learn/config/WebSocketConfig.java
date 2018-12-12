package com.chenjie.springboot.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    /*
    * @Title: serverEndpointExporter
    * @Description: 检测服务类实现
    * @return ServerEndpointExporter
    * @throws
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }
}
