package com.s305089.software.dao;

import com.s305089.software.model.User;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getRootLogger;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao, PersistentTokenRepository {
    private static final Logger log = getRootLogger();

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    public User getBySeries(String series) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("series", series));
        return (User) crit.uniqueResult();
    }

    @Override
    public User findBySSO(String sso) {
        log.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
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

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        log.info("Creating Token for user : {}", token.getUsername());
        User user = new User();
        user.setUsername(token.getUsername());
        user.setSeries(token.getSeries());
        user.setToken(token.getTokenValue());
        user.setLast_used(token.getDate());
        persist(user);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        log.info("Updating Token for seriesId : {}", series);
        User user = getBySeries(series);
        user.setToken(tokenValue);
        user.setLast_used(lastUsed);
        update(user);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        log.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("series", seriesId));
            User user = (User) crit.uniqueResult();

            return new PersistentRememberMeToken(user.getUsername(), user.getSeries(), user.getToken(), user.getLast_used());
        } catch (Exception e) {
            log.info("Token not found...");
            return null;
        }
    }

    @Override
    public void removeUserTokens(String username) {
        log.info("Removing Token if any for user : {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User) crit.uniqueResult();
        if (user != null) {
            log.info("rememberMe was selected");
            delete(user);
        }
    }
}
