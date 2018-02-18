package com.s305089.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String say(ModelMap model) {

        model.addAttribute("user", "Hello world atr");

        return "account/info";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String deposit(Double amount, ModelMap model){

        model.addAttribute("message", "Deposit " + amount);
        model.addAttribute("user", "Hello world atr");
        return "account/info";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdraw(Double amount, ModelMap model){

        model.addAttribute("message", "withdraw " + amount);
        model.addAttribute("user", "Hello world atr");
        return "account/info";
    }

}
