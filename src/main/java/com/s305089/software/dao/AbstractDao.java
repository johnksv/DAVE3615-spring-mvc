package com.s305089.software.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        ParameterizedType superclass = (ParameterizedType) (this.getClass().getGenericSuperclass());
        this.persistentClass = (Class<T>) superclass.getActualTypeArguments()[1];
    }

    @Autowired
    public SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);

        //TODO: Use this instead
        //CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        // return criteriaBuilder.createQuery();
    }
}
