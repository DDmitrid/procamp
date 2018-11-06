package com.globallogic.procamp.lesson5.legacy;

public class Person {
    
    private String name;
    private Company company;

    public Person() {
        this.name = "John Doe";
        this.company = new Company("Oracle");
    }
}
