package com.s305089.software.controller;

import com.s305089.software.model.Account;
import com.s305089.software.model.Loan;
import com.s305089.software.model.User;
import com.s305089.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String info(ModelMap model) {


        //TODO: Return the current logged in user
        User user = userService.findAllUsers().get(0);

        model.addAttribute("user", user);
        model.addAttribute("account", user.getAccounts());
        model.addAttribute("loan", user.getLoans());

        return "account/info";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String deposit(@Validated Double amount, @Validated Double amountCent, @Validated Boolean deposit, ModelMap model) {
        String type = deposit ? "Deposit " : "Withdraw ";

        Double sum = amount + (amountCent / 100);
        model.addAttribute("message", type + sum);
        model.addAttribute("user", "Hello world atr");
        return "account/info";
    }

}
