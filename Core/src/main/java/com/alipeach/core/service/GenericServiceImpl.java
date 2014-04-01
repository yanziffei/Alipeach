package com.alipeach.core.service;

import com.alipeach.core.GenericDao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chen Haoming
 */
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

    private GenericDao<T, PK> dao;

    public GenericServiceImpl (GenericDao<T, PK> dao) {
        this.dao = dao;
    }

    @Override
    public T save (T t) {
        return dao.save (t);
    }

    @Override
    public T get (PK pk) {
        return dao.get (pk);
    }

    @Override
    public void delete (T t) {
        dao.delete (t);
    }

    @Override
    public List<T> save (List<T> list) {
        return dao.save (list);
    }

    @Override
    public void delete (List<T> list) {
        dao.delete (list);
    }

    @Override
    public List<T> find (T t, int offset, int fetchSize) {
        return dao.find (t, offset, fetchSize);
    }

    @Override
    public List<T> findAll (T t) {
        return dao.findAll (t);
    }

    @Override
    public List<T> loadAll () {
        return dao.loadAll ();
    }
}
