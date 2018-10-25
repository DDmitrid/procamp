package com.globallogic.procamp.lesson3.rest.resource;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
                property = "type",
                visible = true)
@JsonSubTypes(value = {
                @JsonSubTypes.Type(value = EbookResource.class, name="EBOOK"),
                @JsonSubTypes.Type(value = BookResource.class, name="BOOK")
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResource {
    
    private String name;
    private String author;
    
    BookType type = BookType.BOOK;
}
