package com.s305089.software.controller;

import com.s305089.software.model.User;
import com.s305089.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        User user = new User();
        user.setPassword("hello");
        user.setEmail("john@gmail.com");
        user.setFirstName("John");
        user.setLastName("Svergja");
        user.setSsoId("123456789");
        userService.saveUser(user);
        return "ok";
    }

    @RequestMapping(value = "/asd", method = RequestMethod.GET)
    public String say(ModelMap model) {
        List<User> allUsers = userService.findAllUsers();
        if(allUsers.size() >0) {
            User user = allUsers.get(0);
            model.addAttribute("user", user);
        }
        return "index";
    }
}
