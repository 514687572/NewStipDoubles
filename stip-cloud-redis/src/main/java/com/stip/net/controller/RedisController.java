package com.stip.net.controller;

import com.stip.net.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/cache")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/setCache")
    public Boolean setCache(@RequestParam String key, @RequestParam Object value) {
        return redisService.set(key, value);
    }

    @GetMapping("/getCache")
    public Object getCache(@RequestParam String key) {
        return redisService.get(key);
    }

    @PostMapping("/setCacheByTime")
    public Boolean setCacheByTime(@RequestParam String key, @RequestParam Object value, @RequestParam Long time) {
        return redisService.set(key, value, time);
    }

    @PostMapping("/removeCache")
    public void removeCache(@RequestParam String key) {
        redisService.remove(key);
    }

    @GetMapping("/existsCache")
    public boolean existsCache(@RequestParam String key) {
        return redisService.exists(key);
    }

    @PostMapping("/setNx")
    public boolean setNx(@RequestParam String key, @RequestParam String value, @RequestParam Long expireTime) {
        return redisService.setNx(key, value, expireTime, TimeUnit.SECONDS);
    }
}
