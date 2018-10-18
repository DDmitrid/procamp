package com.globallogic.procamp.lesson1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/* 
   assertThat org.hamcrest.Matcher
     + instanceOf
     + isA
     -list
     + hasSize
     + contains
     + containsInAnyOrder 
     + everyItem(greaterThan(1))
     -array
     arrayWithSize 

*/
 
// mvn test
// http://maven.apache.org/surefire/maven-surefire-report-plugin/
// mvn surefire-report:report -DshowSuccess=false


public class CalculatorTest {

    private Calculator calculator;
    
    @Before
    public void setUp() throws Exception {
        System.out.println("Using @Before ,executed before each test cases");
        calculator = new Calculator();
        
    }
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Using @BeforeClass , executed before all test cases ");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Using @AfterClass ,executed after all test cases");
    }

    @After
    public void after() {
        System.out.println("Using @After ,executed after each test cases");
    }


    @Test
    public void maxValue() {

        Integer a = 1;
        Integer b = 1_000;
        
        
        //Matchers 
        assertThat(calculator.maxValue(a, b), is(1_000));
    }

    @Test(expected = NullPointerException.class)
    public void maxValueNullPointerException() {
        calculator.maxValue(1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxValueIIllegalArgumentException() {
        calculator.maxValue(null, 1);
    }
    
    @Test
    @Ignore("ignored as unnecessary")
    public void emptyTest() {
        
    }
    
    
}