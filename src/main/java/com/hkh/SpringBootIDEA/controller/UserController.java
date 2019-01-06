package com.hkh.SpringBootIDEA.controller;

import com.hkh.SpringBootIDEA.domain.User;
import com.hkh.SpringBootIDEA.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/usersize")
    public String userSize() {
        return String.valueOf(userRepository.findAll().size());
    }

    @RequestMapping("/getauser")
    @Cacheable(value = "user-key") //value指的是缓存到redis中的key
    public User getUser() {
        User user = userRepository.findByUserName("userB");
        System.out.println("若未出现[无缓存的时候调用]字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getusers")
    @Cacheable(value = "users-key")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("若未出现[无缓存的时候调用]字样且能打印出数据表示测试成功");
        return users;
    }
}
