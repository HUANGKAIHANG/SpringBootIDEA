package com.hkh.SpringBootIDEA.controller;

import com.hkh.SpringBootIDEA.domain.User;
import com.hkh.SpringBootIDEA.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ThymeleafController {
    private final UserRepository userRepository;

    @Autowired
    public ThymeleafController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("hellothymeleaf")
    public String hello(Locale locale, Model model) {
        model.addAttribute("greeting", "Hello! thymeleaf - hkh!");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        return "hello";
    }

    @RequestMapping("allusers")
    public String allUsers(Model model) {
        List<User> allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "allusers";
    }


}
