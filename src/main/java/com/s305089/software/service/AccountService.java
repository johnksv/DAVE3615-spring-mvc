package com.s305089.software.service;

import com.s305089.software.model.Account;

public interface AccountService {
    Account findById(int id);

    void save(Account account);

}
