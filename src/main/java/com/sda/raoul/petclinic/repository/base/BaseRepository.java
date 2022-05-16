package com.sda.raoul.petclinic.repository.base;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {

    Optional<T> findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(ID id);

    List<T> findAll();


}
