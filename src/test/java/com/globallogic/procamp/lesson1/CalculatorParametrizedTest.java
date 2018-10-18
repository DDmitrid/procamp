package com.globallogic.procamp.lesson1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CalculatorParametrizedTest {

    private Integer a;
    private Integer b;
    private Integer max;

    private Calculator calculator;
    

    @Parameterized.Parameters(name = "{index}: a={0}, b={1} max should be ={2}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                        {0, 0, 0},
                        {1, 0, 1},
                        {-1, 0, 0},
                        {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {1_00, 1_000, 1_000}
        });
    }

    public CalculatorParametrizedTest(Integer a, Integer b, Integer max) {
        this.a = a;
        this.b = b;
        this.max = max;
    }

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void maxValue() {
        assertThat(calculator.maxValue(a, b), is(max));
    }
}