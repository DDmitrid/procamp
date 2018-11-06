package com.globallogic.procamp.lesson5.di;

import org.springframework.stereotype.Service;

import com.globallogic.procamp.lesson5.dto.Book;

//@Service
public class AudioBookService implements BookService {
    
    @Override public Book getBook() {
        return new Book("Refactoring");
    }
}
