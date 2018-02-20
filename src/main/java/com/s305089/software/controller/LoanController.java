package com.s305089.software.controller;

import com.s305089.software.model.Loan;
import com.s305089.software.model.LoanType;
import com.s305089.software.service.LoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/loan")
public class LoanController {

    private static final Logger log = LogManager.getRootLogger();

    @Autowired
    LoanService loanService;


    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        LoanType[] values = LoanType.values();
        List<Loan> loans = loanService.findAllLoans();
        model.addAttribute("loanTypes", values);
        model.addAttribute("loans", loans);
        model.addAttribute("loan", new Loan());
        return "loan/apply";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String apply(@Valid Integer loanId) {
        Loan loan = loanService.findById(loanId);
        Loan newLoan = new Loan();
        newLoan.setAmount(loan.getAmount());
        newLoan.setRent(loan.getRent());
        newLoan.setType(loan.getType());
        newLoan.setPayoffTimeMonths(loan.getPayoffTimeMonths());

        //TODO: Assign to current loged in user

        return "loan/apply";
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
