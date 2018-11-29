package com.globallogic.procamp.lesson10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

// 0
public class StackTest {

    private Stack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    @Test
    public void testPush() {
        assertTrue(stack.isEmpty());
        stack.push("element");
        assertFalse(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmpty() {
        stack.pop();
    }

    @Test
    public void testPop() {
        
        stack.push("1");
        stack.push("2");
        Object el = stack.pop();
        
        assertTrue(el.equals("2"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        stack.push("1");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPop() {
        stack.push("1");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackOrder() {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()){
            buffer.append(stack.pop());
        }
        
        assertThat(buffer.toString(), is("4321"));
    }

    @Test
    public void testBeforeGeneric() {
        stack.push("1");
        stack.push("");
        stack.push("new HashSet<>()");
    }

    @Test
    public void name() {
        List<int[]> list = new ArrayList<>();
        
        
    }
}