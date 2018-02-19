package com.s305089.software.controller;

import com.s305089.software.model.Loan;
import com.s305089.software.model.LoanType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loan")
public class LoanController {

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap model) {
        LoanType[] values = LoanType.values();
        model.addAttribute("loanTypes", values);

        return "loan/apply";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String apply(ModelMap model) {

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
