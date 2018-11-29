package com.globallogic.procamp.lesson10.recursive;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.junit.Test;

public class RecursiveTypeBound {

    @Test
    public void testMax() {

        Integer max = max(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(max, is(6));

        Integer maxValue = max(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(maxValue, is(6));

    }

    public static <E extends Comparable<E>> E max(Collection<E> c) {

        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }
    
    /*
        To get the revised declaration from the original, we applied the PECS heuris-
        tic twice. The straightforward application is to the parameter list . It produces T
        instances, so we change the type from List<T> to List<? extends T> . The tricky
        application is to the type parameter T . This is the first time we’ve seen a wildcard
        applied to a type parameter. Originally, T was specified to extend Comparable<T> ,
        but a comparable of T consumes T instances (and produces integers indicating
        order relations). Therefore, the parameterized type Comparable<T> is replaced by
        the bounded wildcard type Comparable<? super T> . Comparables are always
        consumers, so you should generally use Comparable<? super T> in preference to
        Comparable<T> . The same is true of comparators; therefore, you should generally
        use Comparator<? super T> in preference to Comparator<T>
     */

    //    public static <E extends Comparable<? super E>> E max(Collection<? extends E> c) {

}
