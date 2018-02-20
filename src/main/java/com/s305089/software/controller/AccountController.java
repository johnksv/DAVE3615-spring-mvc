package com.s305089.software.controller;

import com.s305089.software.model.Account;
import com.s305089.software.model.Loan;
import com.s305089.software.model.LoanType;
import com.s305089.software.model.User;
import com.s305089.software.service.LoanService;
import com.s305089.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;


    @Autowired
    LoanService loanService;

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
        //TODO: Make new account
        Pattern pattern = Pattern.compile("^[a-zA-ZæøåÆØÅ]+\\s*[a-zA-ZæøåÆØÅ]*$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            Account account = new Account();
            account.setName(name);
            User user = userService.findByUsername(principal.getName());
            user.addAccount(account);
            userService.saveUser(user);
            return "redirect:/account";
        }

        map.addAttribute("formInfo", "Illegal name. Must only contain english letters and max two words.");
        return "account/new";
    }

    @RequestMapping(value = "transaction", method = RequestMethod.GET)
    public String transaction(@Valid @RequestParam String type, @Valid @RequestParam Integer accountId, ModelMap map) {
        if (type != null && accountId != null) {
            if (type.equals("deposit")) {
                map.addAttribute("title", "Deposit");
            } else if (type.equals("withdraw")) {
                map.addAttribute("title", "Withdraw");
            }
        }

        map.addAttribute("accountID", accountId);

        return "account/transaction";
    }

    @RequestMapping(value = "transaction", method = RequestMethod.POST)
    public String transactionPost(@Valid String type, @Valid Integer accountId, @Valid Double amount, ModelMap map, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Optional<Account> accountOpt = user.getAccounts().stream().filter(acc -> acc.getId().equals(accountId)).findFirst();

        if (type != null && accountId != null && accountOpt.isPresent()) {
            Account account = accountOpt.get();
            if (type.equals("deposit")) {
                Double newSum = account.getAmount() + amount;
                account.setAmount(newSum);
            } else if (type.equals("withdraw")) {
                Double newSum = account.getAmount() - amount;
                account.setAmount(newSum);
            }
        }

        return "account/transaction";
    }

}
