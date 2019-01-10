package com.hkh.SpringBootIDEA.controller;

import com.hkh.SpringBootIDEA.domain.mybatisxml.UserEntityXML;
import com.hkh.SpringBootIDEA.mapper.UserXMLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEntityXMLController {

    private final UserXMLMapper userXMLMapper;

    @Autowired(required = false)
    public UserEntityXMLController(UserXMLMapper userXMLMapper) {
        this.userXMLMapper = userXMLMapper;
    }

    @RequestMapping("/getUsersXML")
    public List<UserEntityXML> getAllUsersXML() {
        return userXMLMapper.getAll();
    }

    @RequestMapping(value = "getUserXML/{id}")
    public UserEntityXML getUserXML(@PathVariable("id") Long id) {
        return userXMLMapper.getOne(id);
    }
}
