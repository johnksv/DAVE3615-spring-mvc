package com.s305089.software.controller;

import com.s305089.software.model.Loan;
import com.s305089.software.model.LoanType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loan")
public class LoanController {

    private static final Logger log = LogManager.getRootLogger();

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        LoanType[] values = LoanType.values();
        model.addAttribute("loanTypes", values);
        model.addAttribute("loan", new Loan());
        return "loan/apply";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String apply(@ModelAttribute Loan loan, BindingResult bindingResult) {
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
