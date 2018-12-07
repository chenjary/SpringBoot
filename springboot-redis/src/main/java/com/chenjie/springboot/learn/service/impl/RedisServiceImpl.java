package com.chenjie.springboot.learn.service.impl;

import com.chenjie.springboot.learn.service.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl<T> extends RedisService<T> {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
