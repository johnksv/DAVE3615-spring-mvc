package com.s305089.software.service;

import com.s305089.software.dao.AccountDao;
import com.s305089.software.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao dao;

    @Override
    public Account findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(Account account) {
        dao.save(account);
    }

    @Override
    public boolean exists(int accountId) {
        return findById(accountId) != null;
    }
}
