package com.chenjie.springboot.learn;

import com.chenjie.springboot.learn.entity.ConfigBean;
import com.chenjie.springboot.learn.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({ConfigBean.class,User.class})
@SpringBootApplication
public class SpringbootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConfigApplication.class, args);
    }
}
