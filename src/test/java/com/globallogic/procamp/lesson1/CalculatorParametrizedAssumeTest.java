package com.globallogic.procamp.lesson1;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CalculatorParametrizedAssumeTest {

    private enum TestType {
        NEGATIVE, POSITIVE
    }
    
    private Integer a;
    private Integer b;
    
    private TestType testType;

    private Calculator calculator;


    @Parameterized.Parameters(name = "{index}: {0} :  a={1}, b={2}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                        {TestType.POSITIVE, 0, 0},
                        {TestType.POSITIVE, 1, 0},
                        {TestType.POSITIVE, 1_00, 1_000},

                        {TestType.NEGATIVE, null, 0},
                        {TestType.NEGATIVE, 1, null},
                        {TestType.NEGATIVE, null, null}
        });
    }

    public CalculatorParametrizedAssumeTest(TestType  type, Integer a, Integer b) {
        this.testType = type;
        this.a = a;
        this.b = b;
    }

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test(expected =  Exception.class)
    public void maxValue_negative() {
        Assume.assumeTrue(testType == TestType.NEGATIVE);
        calculator.maxValue(a, b);
    }


    @Test
    public void maxValue_positive() {
        Assume.assumeTrue(testType == TestType.POSITIVE);
        Integer maxValue = calculator.maxValue(a, b);

        assertThat(maxValue, isA(Integer.class));
        assertThat(maxValue, notNullValue());
        assertThat(new Integer[]{a, b}, hasItemInArray(maxValue));
        
    }
}