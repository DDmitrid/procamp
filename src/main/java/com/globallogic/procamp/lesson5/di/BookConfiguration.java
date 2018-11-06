package com.globallogic.procamp.lesson5.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Bean
    @PaperBook
    BookService getPaperBookService() {
        return new PaperBookService();
    }
    
    @Bean
    @AudioBook
    BookService getAudioBookService() {
        return new AudioBookService();
    }
}
