package com.globallogic.procamp;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.globallogic.procamp.lesson5.legacy.Person;

@SpringBootApplication
@ComponentScan("com.globallogic.procamp.lesson5")
public class ProcampApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProcampApplication.class, args);
    }
    
    @Override public void run(ApplicationArguments args) {

        Person person = new Person();

        System.out.println("========================================================");
        System.out.println("===================== Java ProCamp =====================");
        System.out.println("========================================================");
        
        System.out.println(ToStringBuilder.reflectionToString(person, ToStringStyle.MULTI_LINE_STYLE));
    }
}
