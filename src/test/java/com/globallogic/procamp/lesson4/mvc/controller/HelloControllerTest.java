package com.globallogic.procamp.lesson4.mvc.controller;

import static org.junit.Assert.*;
import static org.springframework.core.Conventions.getVariableName;

import java.math.BigDecimal;

import org.junit.Test;

public class HelloControllerTest {

    @Test
    public void displayList() {

        String andriiSivachok = "Andrii Sivachok";
        Integer i = 100;
        
        System.out.println(getVariableName(i));
    }
}