package com.s305089.software.dao;

import com.s305089.software.model.Account;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Integer, Account> implements AccountDao {
    @Override
    public Account findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(Account account) {
        merge(account);
    }
}
