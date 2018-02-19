package com.s305089.software.dao;

import com.s305089.software.model.Loan;

import java.util.List;

public interface LoanDao {

    Loan findById(int id);

    void save(Loan loan);

    List<Loan> findAllLoans();
}
