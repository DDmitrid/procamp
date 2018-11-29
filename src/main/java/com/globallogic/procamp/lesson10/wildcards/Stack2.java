package com.globallogic.procamp.lesson10.wildcards;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/*
    add <E>
    Object ->E
Compile error
    (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
 */
public class Stack2<E> {
    private E[] elements;
    private int size = 0;
    private static final int DFAULT_INITIAL_CAPACITY = 16;

    public Stack2() {
        elements = (E[]) new Object[DFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public void pushAll(Iterable<? extends E> elements) {
        for (E element : elements) {
            push(element);
        }
    }

    public void popAll(Collection<? super E> collection) {
        while (!isEmpty()) {
            collection.add(pop());
        }
    }
    
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        E result = elements[--size];
        elements[size] = null;
        
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
