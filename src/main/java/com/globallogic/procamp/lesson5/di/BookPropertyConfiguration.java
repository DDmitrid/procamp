package com.globallogic.procamp.lesson5.di;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "procamp.book")
@Getter
@Setter
public class BookPropertyConfiguration {
    
    
    private String name;
    private String author;
    private String year;
    
}
