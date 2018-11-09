package com.globallogic.procamp.lesson5.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.globallogic.procamp.lesson5.dto.Book;

//@Service
public class AudioBookService implements BookService {

//    @Value("${book.name}")
//    private String bookName;

//    @Autowired
//    private BookPropertyConfiguration configuration;

    
    @Override public Book getBook() {
        return new Book("Refactoring");
    }
}
