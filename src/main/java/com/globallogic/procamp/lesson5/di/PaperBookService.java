package com.globallogic.procamp.lesson5.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.globallogic.procamp.lesson5.dto.Book;

//@Service
public class PaperBookService implements BookService {

//    @Value("${book.author:Author Name}")
//    private String bookName;
    
    @Override public Book getBook() {
        return new Book("Effective Java 2");
    }
}
