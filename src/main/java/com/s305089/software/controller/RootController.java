package com.s305089.software.controller;

import com.s305089.software.model.User;
import com.s305089.software.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    UserService userService;

    private static final Logger log = LogManager.getRootLogger();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String say(ModelMap model) {
        List<User> allUsers = userService.findAllUsers();
        if(allUsers.size() >0) {
            model.addAttribute("user", allUsers);
        }
        return "index";
    }
}
