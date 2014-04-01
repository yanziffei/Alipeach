package com.alipeach.core.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chen Haoming
 */
public interface GenericService<T, PK extends Serializable> {

    T save (T t);

    T get (PK pk);

    void delete (T t);

    List<T> save (List<T> list);

    void delete (List<T> list);

    List<T> find (T t);

    List<T> loadAll();
}
