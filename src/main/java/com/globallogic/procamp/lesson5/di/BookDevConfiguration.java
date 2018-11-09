package com.globallogic.procamp.lesson5.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class BookDevConfiguration {

    @Bean
    @AudioBook
    BookService getPaperBookService() {
        return new PaperBookService();
    }

    @Bean
    @PaperBook
    BookService getAudioBookService() {
        return new AudioBookService();
    }
}
