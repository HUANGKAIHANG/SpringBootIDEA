package com.hkh.SpringBootIDEA.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {
    //    @RequestMapping({"/","/index"})
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/login") //此方法只是处理异常
    public String login(HttpServletRequest request, Map<String, Object> map) {
        System.out.println("Home控制器login方法执行。。。");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("从request中获取的shiro处理的异常信息=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("账号不存在");
                msg = "UnknownAccountException-->账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("密码不正确：");
                msg = "IncorrectCredentialsException-->密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("验证码错误");
                msg = "kaptchaValidateFailed-->验证码错误：";
            } else {
                System.out.println("出现其它错误：" + exception);
                msg = "else>>" + exception;
            }
        }
        map.put("msg", msg);
        //此方法不处理登录成功，由shiro进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("---------没有权限---------");
        return "403";
    }
}
