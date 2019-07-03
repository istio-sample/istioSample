package com.istio.core1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class Core1Application {

    public static void main(String[] args) {
        SpringApplication.run(Core1Application.class, args);
    }

    @Autowired
    @Lazy
    StringRedisTemplate redisTemplate;

    @PostConstruct
    public void run() throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("name", "정석.lee");
    }

}
