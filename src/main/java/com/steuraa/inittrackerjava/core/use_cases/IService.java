package com.steuraa.inittrackerjava.core.use_cases;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    T getById(Long id);

    T create(T object);

    T update(Long id, T object);

    void delete(Long id);
}
