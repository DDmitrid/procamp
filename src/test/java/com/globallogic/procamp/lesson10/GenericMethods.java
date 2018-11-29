package com.globallogic.procamp.lesson10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GenericMethods {

    @Test
    public void testUnion() {

        Set<String> names = new HashSet<>(Arrays.asList("Tom", "Dick", "Harry"));
        Set<String> ages = new HashSet<>(Arrays.asList("1", "2", "3"));

        System.out.println(union(names, ages));
    }

    /*
        very bad practice
        we should upgrade it 
     */
    private <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }
}
