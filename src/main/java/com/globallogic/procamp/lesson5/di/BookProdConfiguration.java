package com.globallogic.procamp.lesson5.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class BookProdConfiguration {

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
