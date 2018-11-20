package com.globallogic.procamp.lesson8.stream;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumberStreams  {

// IntStream
    
// LongStream
    
// DoubleStream
    
    private void variants() {
                        
        IntStream.of(1, 2, 3);

        IntStream.range(1, 3);
        // > 1, 2
        IntStream.rangeClosed(1, 3);
        // > 1, 2, 3

        IntStream.iterate(0, i -> i + 2).limit(3);
        // > 0, 2, 4

        IntStream.range(1, 5).map(i -> i * i);
        // > 1, 4, 9, 16

        Stream<Integer> stream = IntStream.range(1, 5).boxed();

        DoubleStream doubleStream = IntStream.range(1, 5).mapToDouble(i -> i);

        LongStream longStream = IntStream.range(1, 5).mapToLong(i -> i);

        IntStream.range(1, 5).max().getAsInt();
        // > 4
        IntStream.range(1, 5).min().getAsInt();
        // > 1

        IntStream.range(1, 5).reduce(1, (x, y) -> x * y);
        // > 24

        IntStream.range(1, 101).sum();
        
        IntStream.range(1, 101).average();
        
        IntStream.range(1, 101).filter(i -> i % 2 == 0).count();
    }

    public long count() {
        return IntStream.rangeClosed(0, 1_000_000)
                        .boxed()
                        .filter(x -> x == 1_000_000)
                        .count();
    }

    public Optional<Integer> findAny() {
        return IntStream.rangeClosed(0, 1_000_000)
                        .boxed()
                        .filter(x -> x == 1_000_000)
                        .findAny();
    }

}
