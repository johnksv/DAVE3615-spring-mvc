package com.s305089.software.service;

import com.s305089.software.dao.LoanDao;
import com.s305089.software.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDao dao;

    @Override
    public Loan findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Loan loan) {
        dao.save(loan);
    }

    @Override
    public List<Loan> findAllLoans() {
        return dao.findAllLoans();
    }
}
