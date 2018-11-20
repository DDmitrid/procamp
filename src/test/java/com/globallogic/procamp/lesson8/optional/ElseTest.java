package com.globallogic.procamp.lesson8.optional;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class ElseTest {

    private static final Optional<String> EFFECTIVE_JAVA = Optional.ofNullable("Effective Java");
    private static final Optional<String> EMPTY = Optional.ofNullable(null);

    @Test
    public void value_exist_orElse() {
        System.out.println(Else.OR_ELSE.getName(EFFECTIVE_JAVA));   
    }

    @Test
    public void value_missing_orElse() {
        System.out.println(Else.OR_ELSE.getName(EMPTY));
    }

    @Test
    public void value_exist_orElseGet() {
        System.out.println(Else.OR_ELSE_GET.getName(EFFECTIVE_JAVA));
    }

    @Test
    public void value_missing_orElseGet() {
        System.out.println(Else.OR_ELSE_GET.getName(EMPTY));
    }
}