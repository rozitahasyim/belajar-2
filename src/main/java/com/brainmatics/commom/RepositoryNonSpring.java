package com.brainmatics.commom;

import java.util.List;

public interface Repository<E> {
    int getCount();
    E getById(int id);
    List<E> getAll();
    void insert(E entity) ;
    void update(E entity);
    void remove(int id);
}
