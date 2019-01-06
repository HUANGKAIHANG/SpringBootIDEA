package com.hkh.SpringBootIDEA.util;

import com.hkh.SpringBootIDEA.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        System.out.println("开始stringRedisTemplate手动使用测试");
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        System.out.println("开始redisTemplate手动使用测试");
        User user = new User("redis_username", "redis_password", "redis@126.com", "redis_nickname", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.hkhx", user);
        operations.set("com.hkh.f", user, 1, TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        redisTemplate.delete("com.hkh.f");
        boolean exists = redisTemplate.hasKey("com.hkh.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        exists = redisTemplate.hasKey("com.hkhx");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
//        System.out.println(operations.get("com.hkhx").getUserName());
//        System.out.println(operations.get("com.hkh.f").getUserName());
//        Assert.assertEquals("redis_username",operations.get("com.hkh.f").getUserName());
    }
}
