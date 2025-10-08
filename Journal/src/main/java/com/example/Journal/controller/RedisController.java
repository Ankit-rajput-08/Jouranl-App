package com.example.Journal.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private final StringRedisTemplate redisTemplate;

    public RedisController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @GetMapping
    public String testRedis() {
        redisTemplate.opsForValue().set("mykey", "HelloSpring");
        String mykey = redisTemplate.opsForValue().get("mykey");
        return mykey;
    }
}
