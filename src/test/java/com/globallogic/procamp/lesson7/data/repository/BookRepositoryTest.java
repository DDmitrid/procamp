package com.globallogic.procamp.lesson7.data.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Optional;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.procamp.lesson7.data.entity.Book;
import com.globallogic.procamp.lesson7.data.mapper.BookMapper;

public class BookRepositoryTest extends BaseRunner {

    @Autowired
    private BookRepository bookRepository;

    private BookMapper bookMapper= Mappers.getMapper(BookMapper.class);

    @Test
    @Ignore
    public void testFindOne() {

        Optional<Book> bookOptional = bookRepository.findById(1);
        assertTrue(bookOptional.isPresent());
        Book book = bookOptional.get();

        assertThat(book.getName(), is("Refactoring"));
        ReflectionToStringBuilder.reflectionToString(book);
        
    }

    @Test
    public void testFindByName() {
        Book book = bookRepository.findByName("Refactoring");
        assertThat(book.getId(), is(1));
    }

    @Test
    public void testFindByName_Null() {
        Book book = bookRepository.findByName(null);
    }

    @Test
    @Ignore
    public void testMapper() {

        Optional<Book> bookOptional = bookRepository.findById(1);
        Book book = bookOptional.get();
        
        System.out.println(ReflectionToStringBuilder.reflectionToString(bookMapper.map(book)));
    }
}