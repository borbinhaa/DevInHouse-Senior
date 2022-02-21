package com.SecondTry.ClientAccount.repository;

import java.util.List;


public interface CrudRepository<T> {
    List<T> getAll();
    T findById(int id);
    int add(T t);
    T update(int id, T t);
    T delete(int id);
}
