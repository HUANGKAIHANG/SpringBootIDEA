package com.hkh.SpringBootIDEA.controller;

import com.hkh.SpringBootIDEA.domain.mybatis.UserEntity;
import com.hkh.SpringBootIDEA.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEntityController {

    //不写required属性也没事，只是IDE报错
    private final UserMapper userMapper;

    @Autowired(required = false)
    public UserEntityController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/getUserEntities")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUserEntity")
    public UserEntity getUser(Long id) {
        UserEntity user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/getOneUser/{id}")
    public UserEntity getOneUser(@PathVariable("id") Long id) {
        UserEntity user = userMapper.getOne(id);
        return user;
    }
}
