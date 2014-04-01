package com.alipeach.core.hibernate;

import com.alipeach.core.GenericDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chen Haoming
 */
public class HibernateGenericDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> persistentClass;

    private SessionFactory sessionFactory;

    public HibernateGenericDao (Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T save (T t) {
        sessionFactory.getCurrentSession ().save (t);
        return t;
    }

    @SuppressWarnings ("unchecked")
    @Override
    public T get (PK pk) {
        return (T) sessionFactory.getCurrentSession ().get (persistentClass, pk);
    }

    @Override
    public void delete (T t) {
        sessionFactory.getCurrentSession ().delete (t);
    }

    @Override
    public List<T> save (List<T> list) {
        Session session = sessionFactory.getCurrentSession ();
        for (T t : list) {
            session.save (t);
        }
        return list;
    }

    @Override
    public void delete (List<T> list) {
        Session session = sessionFactory.getCurrentSession ();
        for(T t : list) {
            session.delete (t);
        }
    }

    @SuppressWarnings ("unchecked")
    @Override
    public List<T> find (T t) {
        return sessionFactory.getCurrentSession ().createCriteria (persistentClass).add (Example.create (t)).list ();
    }

    @SuppressWarnings ("unchecked")
    @Override
    public List<T> loadAll () {
        return sessionFactory.getCurrentSession ().createCriteria (persistentClass).list ();
    }

}
