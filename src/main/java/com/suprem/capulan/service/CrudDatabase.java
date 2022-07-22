package com.suprem.capulan.service;

import java.util.List;
import java.util.Optional;

public interface CrudDatabase<T> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    void deleteById(Integer id);

}
