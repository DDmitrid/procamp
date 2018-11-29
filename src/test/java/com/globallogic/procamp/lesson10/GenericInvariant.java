package com.globallogic.procamp.lesson10;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

/*
        Arrays differ from generic types in two important ways.
        First, arrays are covariant.
        This scary-sounding word means simply that if Sub is a subtype of Super,
        then the array type Sub[] is a subtype of the array type Super[].
        Generics, by contrast, are invariant: 
        for any two distinct types Type1 and Type2, List<Type1>
        is neither a subtype nor a supertype of List<Type2>
*/

public class GenericInvariant {

    /*
         example array is Covariant 
     */
    @Test
    public void covariantArray () {
        // Fails at runtime!

        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
    }
    
    /*
        example List is Invariant
        Won't compile
     */
    @Test
    public void invarianGeneric() {
//        List<Number> list = new ArrayList<Long>();
    }

    /*
        Unsafe Raw type
     */
    @Test
    public void testClassCastException() {
        List list = new ArrayList();

        list.add("text");
        list.add(1);
        list.add(BigDecimal.TEN);

/*     
        for (Object o : list) {
            System.out.println(o);
        }
*/
        list.stream().forEach(System.out::println);

/*       
        int i = 0; 
        for (Object o : list) {
            i = i+ (Integer) o;
        }
*/
        list.stream().mapToInt(Integer.class::cast).sum();
    }

    @Test
    public void testAddToUnboundedWildcardType() {
        List<?> list = new ArrayList<Integer>();
        //        list.add(1);
    }


    

    

    @Test
    public void callCovariant() {
        Number[] numbers = new Integer[]{1, 2,3,4,5};
        covariant(numbers);
    }

    @Test
    public void genericInvariant() {
//     Won't compile!
//       List<Object> list = new ArrayList<Long>(); // Incompatible types
    }

    @Test
    public void callInvariant() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
//    Won't compile!
//      invariant(list); // re-run with List<Number>
    }

    private void covariant(Number[] numberArray) {
        Stream.of(numberArray).forEach(System.out::println);
    }

    private void invariant(List<Number> numberList) {
        numberList.stream().forEach(System.out::println);
    }

    /*
        none of these array creation expressions are legal
     */
    @Test
    public <E> void  genericArrayCreation() {
//        new List<E>[];
//        new List<String>[];
//        new E[];                
    }

    // not very good example, avoid mix generic and varargs 
    @Test
    public void callVarargsGeneric() {
        varargsGeneric(new Integer(10), BigDecimal.TEN);        
    }

    private final <E> void varargsGeneric(E... objects) {
    /*
        When you get a generic array creation error or an unchecked cast warning on a
        cast to an array type, the best solution is often to use the collection type List<E> in
        preference to the array type E[].
     */
        List<E> list = Arrays.asList(objects);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void name() {
        System.out.println(this.<String, Integer>genericMethod(123));
    }

    public <T, P> T genericMethod(P t) {
        return (T) t;
    }

}