package com.steuraa.inittrackerjava.core.gateways;

import java.util.List;
import java.util.Optional;

public interface Gateway<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    <S extends T> S save(S object);

    void deleteById(Long id);
}
