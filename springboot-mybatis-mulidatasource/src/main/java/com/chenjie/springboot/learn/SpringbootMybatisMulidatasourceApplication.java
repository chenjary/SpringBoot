package com.chenjie.springboot.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootMybatisMulidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisMulidatasourceApplication.class, args);
    }

}

