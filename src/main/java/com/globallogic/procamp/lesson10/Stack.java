package com.globallogic.procamp.lesson10;

import java.util.Arrays;
import java.util.EmptyStackException;
/*
    add <E>
    Object ->E
Compile error
    (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    
    TESTS
 */
public class Stack<E> {
    
    private E[] elements;
    private int size = 0;
    private static final int DFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = (E[]) new Object[DFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
