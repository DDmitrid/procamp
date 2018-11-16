package com.globallogic.procamp.lesson7.data.repository;

import java.util.Optional;

import com.globallogic.procamp.lesson7.data.entity.Book;

public class BookRepositoryImpl<Book, Integer> implements CustomRepository<Book, Integer> {
    
    @Override public Optional<Book> findById(Integer integer) {
        return Optional.empty();
    }

    @Override public <S extends Book> S save(S entity) {
        return null;
    }
}
