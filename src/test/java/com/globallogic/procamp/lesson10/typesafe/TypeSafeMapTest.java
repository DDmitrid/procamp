package com.globallogic.procamp.lesson10.typesafe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TypeSafeMapTest {

    @Test
    public void name() {
        TypeSafeMap f = new TypeSafeMap();
        
        f.put(String.class, "Java");
        f.put(Integer.class, 0xcafebabe);
        f.put(Class.class, TypeSafeMap.class);

        String favoriteString = f.get(String.class);
        int favoriteInteger = f.get(Integer.class);
        Class<?> favoriteClass = f.get(Class.class);

        System.out.printf("%s %x %s%n", favoriteString,
                        favoriteInteger, favoriteClass.getName());
    }

    @Test
    public void name2() {

//        List<? extends Number> intList = new ArrayList<>();
//        List<? extends Integer>  numList = intList;
        


    }
}