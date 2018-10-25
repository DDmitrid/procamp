package com.globallogic.procamp.lesson3.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.procamp.lesson3.rest.resource.BookResource;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "books")
public class BookController {
    
    @RequestMapping(
                    method = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST}, //several methods
                    headers = {"key=value", "key_2=value_2"}, // specific header
                    value = {"/", "list", "all"} // books books/list books/all
                    
    )
    @ApiOperation(value = "Get list of books")
    public List<BookResource> getBooks(@RequestParam(required = false, defaultValue = "Joshua Bloch") String author) {
        return Arrays.asList(
                        BookResource.builder().name ("Effective Java 2").author(author).build(),
                        BookResource.builder().name("Refactoring").author("Martin Fowler").build(),
                        BookResource.builder().name("Refactoring2 ").author("Martin Fowler").build()
        );
    }

//    @GetMapping(value = "/{id}")
    @GetMapping(value = "{id:\\d{6,8}}") //regexp for path variable  
    @ApiOperation(value = "Get book by id")
    public ResponseEntity<BookResource> getBook(@PathVariable long id) {
        BookResource book = BookResource.builder()
                        .name("Head First Design Patterns")
                        .author("Bert Bates, Kathy Sierra, Eric Freeman, Elisabeth Robson")
                        .build();
                return new ResponseEntity(book, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Add new book")
    public BookResource addBook(@RequestBody BookResource book) {
        return book;
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update book by id")
    public BookResource updateBook(@RequestBody BookResource book, @PathVariable String id) {
        return book;
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> partialUpdateGeneric(
                    @RequestBody Map<String, Object> updates,
                    @PathVariable("id") String id) {
        // .....
        return ResponseEntity.ok("resource updated");
    }
    
    
    
}
