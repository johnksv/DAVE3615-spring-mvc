package com.s305089.software.service;

import com.s305089.software.model.Loan;

import java.util.List;

public interface LoanService {

    Loan findById(int id);

    void save(Loan loan);

    List<Loan> findAllLoans();
}
