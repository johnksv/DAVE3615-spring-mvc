package com.s305089.software.service;

import com.s305089.software.model.Account;

import javax.validation.Valid;

public interface AccountService {
    Account findById(int id);

    void save(Account account);

    boolean exists(int accountId);
}
