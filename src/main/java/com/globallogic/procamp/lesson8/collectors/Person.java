package com.globallogic.procamp.lesson8.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    City city;
    String name;
    int age;
}
