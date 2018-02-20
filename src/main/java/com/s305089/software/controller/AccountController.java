package com.s305089.software.controller;

import com.s305089.software.model.Account;
import com.s305089.software.model.User;
import com.s305089.software.service.AccountService;
import com.s305089.software.service.LoanService;
import com.s305089.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String info(ModelMap model, Principal principal) {
        User user = userService.findByUsername(principal.getName());

        model.addAttribute("user", user);
        model.addAttribute("account", user.getAccounts());
        model.addAttribute("loan", user.getLoans());

        return "account/info";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newAccount(ModelMap map) {

        map.addAttribute("formInfo", "The name can only contain english letters and max two words.");
        return "account/new";
    }


    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String newAccountPost(@Valid String name, ModelMap map, Principal principal) {
        Pattern pattern = Pattern.compile("^[a-zA-ZæøåÆØÅ]+\\s*[a-zA-ZæøåÆØÅ]*$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            User user = userService.findByUsername(principal.getName());
            Account account = new Account();
            account.setName(name);
            account.setOwner(user);
            accountService.save(account);
            return "redirect:/account";
        }

        map.addAttribute("formInfo", "Illegal name. Must only contain english letters and max two words.");
        return "account/new";
    }

    @RequestMapping(value = "transaction", method = RequestMethod.GET)
    public String transaction(@Valid @RequestParam String type, @Valid @RequestParam Integer accountId, ModelMap map) {


        if (type != null && accountId != null && accountService.exists(accountId)) {
            if (type.equals("deposit")) {
                map.addAttribute("title", "Deposit");
            } else if (type.equals("withdraw")) {
                map.addAttribute("title", "Withdraw");
            }

            map.addAttribute("accountID", accountId);

            return "account/transaction";
        }

        //If any of the parameters are invalid
        return "redirect:/account";
    }

    @RequestMapping(value = "transaction", method = RequestMethod.POST)
    public String transactionPost(@Valid String type, @Valid Integer accountId, @Valid Double amount, ModelMap map) {
        Account account = accountService.findById(accountId);

        if (type != null && account != null) {

            if (type.equals("deposit")) {
                Double newSum = account.getAmount() + amount;
                account.setAmount(newSum);
            } else if (type.equals("withdraw")) {
                Double newSum = account.getAmount() - amount;
                account.setAmount(newSum);
            }
            accountService.save(account);
            return "redirect:/account";
        }

        return "account/transaction";
    }

}
