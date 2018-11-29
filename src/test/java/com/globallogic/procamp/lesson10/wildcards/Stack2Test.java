package com.globallogic.procamp.lesson10.wildcards;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.globallogic.procamp.lesson10.wildcards.Stack2;

public class Stack2Test {

    @Test
    public void testPushAll() {

        Stack2<Number> stack = new Stack2<>();
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        
        
        stack.pushAll(list);
    }

    @Test
    public void testPopAll() {
        Stack2<Integer> stack = new Stack2<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Collection<Number> dst = new ArrayList<>();
        stack.popAll(dst);
    }

    @Test
    public void testSum() {

    }

    public static double sum(List<? extends Number> numberlist) {
        
        return numberlist.stream()
                        .map(Number::doubleValue)
                        .mapToDouble(Double.class::cast)
                        .sum();
        
//        double sum = 0.0;
//        for (Number n : numberlist) sum += n.doubleValue();
//        return sum;
    }
}