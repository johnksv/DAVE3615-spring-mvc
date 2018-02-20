package com.s305089.software.controller;

import com.s305089.software.model.Account;
import com.s305089.software.model.User;
import com.s305089.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    private User user = null;

    @RequestMapping(method = RequestMethod.GET)
    public String info(ModelMap model) {


        //TODO: Return the current logged in user
        if (user == null) {
            user = userService.findAllUsers().get(0);
        }

        model.addAttribute("user", user);
        model.addAttribute("account", user.getAccounts());
        model.addAttribute("loan", user.getLoans());

        return "account/info";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String deposit(@Valid Double amount, @Valid Double amountCent, @Valid Boolean deposit, ModelMap model) {
        String type = deposit ? "Deposit " : "Withdraw ";

        Double sum = amount + (amountCent / 100);
        model.addAttribute("message", type + sum);
        model.addAttribute("user", user);
        return "account/info";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newAccount(ModelMap map) {

        map.addAttribute("formInfo", "Illegal name. Must only contain english letters and max two words.");
        return "account/new";
    }


    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String newAccountPost(@Valid String name, ModelMap map) {
        //TODO: Make new account
        Pattern pattern = Pattern.compile("^[a-zA-ZæøåÆØÅ]+\\s*[a-zA-ZæøåÆØÅ]*$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            Account account = new Account();
            account.setName(name);
            user.addAccount(account);
            userService.saveUser(user);
            return "redirect:/account";
        }

        map.addAttribute("formInfo", "Illegal name. Must only contain english letters and max two words.");
        return "account/new";
    }

}
