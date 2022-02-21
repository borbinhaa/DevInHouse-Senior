package com.SecondTry.ClientAccount.service;

import java.util.List;

public interface CrudService<T> {
    List<T> get();
    T findById(int id);
    T update(int id, T t);
    int add(T t);
    T delete(int id);
}
