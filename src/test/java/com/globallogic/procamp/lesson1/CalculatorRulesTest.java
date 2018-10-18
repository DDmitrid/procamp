package com.globallogic.procamp.lesson1;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

public class CalculatorRulesTest {

    private Calculator calculator;

    @Rule 
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void name() {
        collector.checkThat("2 must be greater than 1", calculator.maxValue(1, 2), equalTo(2));
        collector.checkThat("2 must be greater than 1", calculator.maxValue(2, 3), equalTo(1));
        collector.checkThat("2 must be greater than 1", calculator.maxValue(3, 4), equalTo(4));
    }

    @Test
    public void npe() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage(containsString("second param"));
        
        calculator.maxValue(1, null);
    }
}