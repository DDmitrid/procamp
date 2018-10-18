package com.globallogic.procamp.lesson1;

import org.glassfish.jersey.internal.guava.Preconditions;

public class Calculator {
    
    public Integer maxValue(Integer a, Integer b) {
        Preconditions.checkArgument(a != null);
        Preconditions.checkNotNull(b, "second param is null");
        
        if (a < b) {
            return b;
        }
        return a;
    }
}