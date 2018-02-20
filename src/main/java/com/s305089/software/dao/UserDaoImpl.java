package com.s305089.software.dao;

import com.s305089.software.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
    private static final Logger log = LogManager.getRootLogger();

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    public User findByUsername(String username) {
        log.info("Username : {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        return (User) crit.uniqueResult();
    }

    @Override
    public void save(User user) {
        merge(user);
    }

    @Override
    public void deleteByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        //To avoid duplicates.
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (List<User>) criteria.list();
    }

}
