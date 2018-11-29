package com.globallogic.procamp.lesson10.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Wildcards {

    @Test
    public void testPrint() {
//        List<String> list = new ArrayList<>();
//
//        list.add("1");
//        list.add("2");
//        list.add("3");
//
//        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
                        
        
//        printCollection(list);
//        printCollection2(new ArrayList<>(list));
//        printCollection3(intList);

        Set<Integer> intSet = new HashSet<>();
        set(intSet);

        intSet.stream().mapToInt(Integer.class::cast).sum();
    }
    
    
    private void set(Set<? extends Number> set) {
        System.out.println(set);
    }

    void printCollection(Collection c) {
        Iterator i = c.iterator();
       
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }

    /*
        Whereas the old code could be called with any kind of collection as a parameter, the new code only takes Collection<Object>,
        which, as we've just demonstrated, is not a supertype of all kinds of collections!
     */
    void printCollection2(Collection<Object> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    /*
        collection whose element type matches anything. It's called a wildcard type for obvious reasons
     */
    void printCollection3(Collection<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    /*
            :-(
     */
    @Test
    public void testAddToWildcart() {
        List<? extends Number> list = new ArrayList<>();

        //        list.add(new Integer(1));
        //        list.add(new Double(1));
        //        list.add(new Long(1));
    }
}
