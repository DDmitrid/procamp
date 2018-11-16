package com.globallogic.procamp.lesson7.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.globallogic.procamp.lesson7.data.dto.BookDto;
import com.globallogic.procamp.lesson7.data.entity.Book;

@Mapper(config = MappingConfig.class)
public interface BookMapper {
    BookDto map(Book book);
}