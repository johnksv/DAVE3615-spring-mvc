package com.s305089.software.controller;

import com.s305089.software.model.Loan;
import com.s305089.software.model.LoanType;
import com.s305089.software.model.User;
import com.s305089.software.service.LoanService;
import com.s305089.software.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/loan")
public class LoanController {

    private static final Logger log = LogManager.getRootLogger();

    @Autowired
    UserService userService;

    @Autowired
    LoanService loanService;


    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        LoanType[] values = LoanType.values();
        //Loans without owner is the "template"-loans. Another solution is to add a field on the loan model; "boolean template"
        List<Loan> loans = loanService.findAllLoans().stream().filter(loan -> loan.getOwner() == null).collect(Collectors.toList());
        model.addAttribute("loanTypes", values);
        model.addAttribute("loans", loans);
        model.addAttribute("loan", new Loan());
        return "loan/apply";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String apply(@Valid Integer loanId, Principal principal) {
        Loan oldLoan = loanService.findById(loanId);

        User user = userService.findByUsername(principal.getName());

        Loan loan = new Loan();
        loan.setAmount(oldLoan.getAmount());
        loan.setRent(oldLoan.getRent());
        loan.setType(oldLoan.getType());
        loan.setPayoffTimeMonths(oldLoan.getPayoffTimeMonths());
        loan.setOwner(user);
        loan.setStart(new Date());

        loanService.save(loan);

        return "redirect:account";
    }

    @RequestMapping(value = "custom", method = RequestMethod.POST)
    public String applyCustom(@ModelAttribute Loan loan, BindingResult bindingResult) {
        log.fatal("Testing fatal logging");
        return "loan/apply";
    }

    @ResponseBody
    @RequestMapping(value = "calcInterest", method = RequestMethod.GET, produces = "text/plain")
    public String calcInterest(Loan loan, ModelMap model) {
        LoanType[] values = LoanType.values();
        model.addAttribute("loanTypes", values);

        return "loan/apply";
    }

}
