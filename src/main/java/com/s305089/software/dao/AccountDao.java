package com.s305089.software.dao;

import com.s305089.software.model.Account;

public interface AccountDao {

    Account findById(int id);

    void save(Account account);
}
