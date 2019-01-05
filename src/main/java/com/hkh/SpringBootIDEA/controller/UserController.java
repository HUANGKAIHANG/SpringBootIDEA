package com.hkh.SpringBootIDEA.controller;

import com.hkh.SpringBootIDEA.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
