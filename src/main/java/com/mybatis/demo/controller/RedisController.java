package com.mybatis.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/getKey")
    public String getKey(@RequestBody JSONObject requestJson) {
        String key = (String) requestJson.get("key");
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }
}
