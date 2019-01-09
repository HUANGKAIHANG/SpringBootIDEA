package com.hkh.SpringBootIDEA.controller;

import com.hkh.SpringBootIDEA.domain.NewUser;
import com.hkh.SpringBootIDEA.service.NewUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class NewUserController {

    @Resource
    NewUserService newUserService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<NewUser> newUsers = newUserService.getNewUserList();
        model.addAttribute("newUsers", newUsers);
//        return "newUser/list";
        return "newUser/listS";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
//        return "newUser/newUserAdd";
        return "newUser/newUserAddS";
    }

    @RequestMapping("/add")
    public String add(NewUser newUser) {
        newUserService.save(newUser);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        NewUser newUser = newUserService.findNewUserById(id);
        model.addAttribute("newUser", newUser);
//        return "newUser/newUserEdit";
        return "newUser/newUserEditS";
    }

    @RequestMapping("edit")
    public String edit(NewUser newUser) {
        newUserService.edit(newUser);
        return "redirect:/list";
    }

    @RequestMapping("delete")
    public String delete(Long id) {
        newUserService.delete(id);
        return "redirect:/list";
    }
}
