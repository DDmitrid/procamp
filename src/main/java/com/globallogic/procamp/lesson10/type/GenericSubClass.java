package com.globallogic.procamp.lesson10.type;

public class GenericSubClass extends GenericSuperclass<String, Integer> {

    public static void main(String[] args) {
        new GenericSubClass().run();
    }
}
