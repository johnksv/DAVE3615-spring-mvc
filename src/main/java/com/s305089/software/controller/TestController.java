package com.s305089.software.controller;

import com.s305089.software.model.Account;
import com.s305089.software.model.Loan;
import com.s305089.software.model.LoanType;
import com.s305089.software.model.User;
import com.s305089.software.service.LoanService;
import com.s305089.software.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger log = LogManager.getRootLogger();

    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        User user = new User();
        user.setPassword("hello");
        user.setEmail("john@gmail.com");
        user.setFirstName("John");
        user.setLastName("Svergja");
        user.setSSN("123456-78778");
        user.setUsername("123456789");
        user.getAccounts().add(new Account());
        userService.saveUser(user);

        Loan a = new Loan(LoanType.STUDENT_LOAN, 190500.00,5.4, 96);

        loanService.save(a);

        log.fatal(passwordEncoder.encode("hello"));

        return "ok";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String say(ModelMap model) {
        List<User> allUsers = userService.findAllUsers();
        if(allUsers.size() >0) {
            User user = allUsers.get(0);
            model.addAttribute("user", user);
        }
        return "index";
    }
}
