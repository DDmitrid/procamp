package com.globallogic.procamp.lesson8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.globallogic.procamp.lesson8.entity.Tutorial;

/*
 examples how create stream 
 */
public class Creation {

    public Stream<String> getStreamFromList() {
        return Arrays.asList("A", "B").stream();
    }

    public Stream<String> getStreamFromElements() {
        return Stream.of("A", "B");
    }

    public Stream<Tutorial> generateStreamByMappingCopies(int n) {
        return Collections.nCopies(n, "mock").stream()
                        .map(s -> new Tutorial());
    }

    public Stream<Tutorial> generateStreamFromRange(int n) {
        return IntStream.range(0, n).mapToObj(i -> new Tutorial());
    }

    public Stream<Tutorial> generateStreamFromSupplierWithLimit(int n) {
        return Stream.generate(Tutorial::new).limit(n);
    }

    public Stream<Tutorial> generateStreamFromArrayWithRange(Tutorial[] tutorials, int max) {
        int to = Integer.min(tutorials.length, max);
        return IntStream.range(0, to).mapToObj(i -> tutorials[i]);
    }

    public Stream<Tutorial> generateStreamFromArrayWithLimit(Tutorial[] roles, int max) {
        return Stream.of(roles).limit(max);
    }
}
