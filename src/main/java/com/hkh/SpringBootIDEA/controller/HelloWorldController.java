package com.hkh.SpringBootIDEA.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller里面的方法都以json格式输出，不用写jackjson配置
public class HelloWorldController {

    @RequestMapping("/hello2")
    public String index(){
        return "Hello World in IntelliJ IDEA";
    }
}
