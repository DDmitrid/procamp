package com.globallogic.procamp.lesson3.rest.resource;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class EbookResource extends BookResource {
    BookType type = BookType.EBOOK;
    String url;
}
