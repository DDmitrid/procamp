package com.globallogic.procamp.lesson5.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.procamp.lesson5.dto.Book;

@RestController
@RequestMapping(value = "/di")
public class BooksController {

    @Autowired
    @PaperBook
    private BookService bookService;

//    public BooksController( BookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping
    public Book getBook() {
        return bookService.getBook();
    }
}
