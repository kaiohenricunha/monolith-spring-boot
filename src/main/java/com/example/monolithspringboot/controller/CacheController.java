package com.example.monolithspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/set")
    public void setCache(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @GetMapping("/get")
    public String getCache(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
