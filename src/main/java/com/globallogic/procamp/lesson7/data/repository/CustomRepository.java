package com.globallogic.procamp.lesson7.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CustomRepository<T, ID> extends Repository<T, ID> {
    
    Optional<T> findById(ID id);

    <S extends T> S save(S entity);
}
