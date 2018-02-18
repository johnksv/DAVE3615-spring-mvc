package com.s305089.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String deposit(@Validated Double amount,@Validated Double amountCent, @Validated Boolean deposit, ModelMap model){
        String type = deposit ? "Deposit " : "Withdraw ";

        Double sum = amount + (amountCent/100);
        model.addAttribute("message", type + sum);
        model.addAttribute("user", "Hello world atr");
        return "account/info";
    }

}
