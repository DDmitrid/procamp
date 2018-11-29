package com.globallogic.procamp.lesson10.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class F{

    @Test
    public void name() {
        /*
            ? extend B
            a B C
        */
        List<C> listB = new ArrayList<>();
        this.<B>check(listB);

        
        /*
            ? super B
            A B c
        */
        List<B> listSuper = new ArrayList<>();
        this.<B>checkSuper(listSuper);
        
        
        
        
    }
    
    
    private <Type> void check(Collection<? extends Type> smth) {
        
    }

    private <Type> void checkSuper(Collection<? super Type> smth) {

    }
    
    

}
class A {
}

class B extends A {
}

class C extends B {
}

