package com.s305089.software.dao;

import com.s305089.software.model.Loan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import java.util.List;

public class LoanDaoImpl extends AbstractDao<Integer, Loan> implements LoanDao {

    private static final Logger log = LogManager.getRootLogger();

    @Override
    public Loan findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(Loan loan) {
        log.info("Loan : {}", loan);
        persist(loan);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Loan> findAllLoans() {
        return (List<Loan>) createEntityCriteria()
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
