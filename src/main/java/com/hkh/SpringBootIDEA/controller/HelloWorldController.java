package com.hkh.SpringBootIDEA.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController //controller里面的方法都以json格式输出，不用写jackjson配置
public class HelloWorldController {

    @RequestMapping("/hello2")
    public String index() {
        return "spring boot project in IDEA -- hkh";
    }

    @RequestMapping("/uid")
    String uid(HttpSession session){
        UUID uid = (UUID)session.getAttribute("uid");
        if (uid==null){
            uid = UUID.randomUUID();
        }
        System.out.println("uid="+uid);
        session.setAttribute("uid",uid);
        return session.getId()+" is Id and uid="+session.getAttribute("uid");
    }
}
