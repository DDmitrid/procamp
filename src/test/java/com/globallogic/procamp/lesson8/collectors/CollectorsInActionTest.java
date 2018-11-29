package com.globallogic.procamp.lesson8.collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.globallogic.procamp.lesson8.entity.Tutorial;

public class CollectorsInActionTest {

    List<Person> persons = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        persons.add(new Person(City.KIEV, "Ivan", 42));
        persons.add(new Person(City.NIKOLAEV, "Petro", 21));
        persons.add(new Person(City.ODESSA, "Taras", 33));
        persons.add(new Person(City.NIKOLAEV, "Max", 33));
//        persons.add(new Person(City.ODESSA, "Max", 12));
    }

    // map name :: age

    @Test
    public void nameAge() {
        Map<City, String> collect = persons.stream().collect(toMap(Person::getCity, Person::getName, (c1, c2)->c2+""+c1));
        System.out.println(collect);
        
    }
    
    // map name :: object 

    @Test
    public void nameIdentity() {
        Map<String, Person> collect = persons.stream().collect(toMap(Person::getName, Function.identity()));
        System.out.println(collect);
    }

    //  Set of ages 
    @Test
    public void setOfAges() {
        Set<Integer> collect = persons.stream()
                        .map(Person::getAge)
                        .collect(Collectors.toSet());

        System.out.println(collect);

    }

    //  people by age
    @Test
    public void peopleByAge() {
//        Map<Integer, List<Person>>

        Map<Integer, Set<Person>> collect = persons.stream()
                        .collect(groupingBy(Person::getAge, toSet()));

        System.out.println(collect);

    }

    //  names by age
    @Test
    public void namesByAge() {
//        Map<Integer, Set<String>>

        Map<Integer, Set<String>> collect = persons.stream()
                        .collect(groupingBy(Person::getAge, mapping(Person::getName, toSet())));

        System.out.println(collect);

    }

    

    //  population by age
    @Test
    public void populationByAge() {
//        Map<Integer, Long> 
        Map<Integer, Long> collect = persons.stream()
                        .collect(groupingBy(Person::getAge, counting()));

        System.out.println(collect);

    }

    //  cities with more than one occupant
    @Test
    public void citiesWithMoreThanOneOccupant() {
        List<City> collect = persons.stream()
                        .collect(groupingBy(Person::getCity, counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
        
        System.out.println(collect);
    }

    // most popular age
    @Test
    public void mostPopularAge() {
//        Integer integer

        Integer integer = persons.stream().collect(groupingBy(Person::getAge, counting()))
                        .entrySet().stream()
                        .max(comparing(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElse(null);

        System.out.println(integer);

    }

    // group by city, produce coma separated concatenation of names

    @Test
    public void concatenation() {
//        Map<City, String>

        Map<City, String> collect = persons.stream()
                        .collect(groupingBy(Person::getCity, mapping(Person::getName, joining(", ", "[", "]"))));

        System.out.println(collect);
        
    }

    // =================================

    // Getting the Maximum or Minimum from Grouped Results
    @Test
    public void name1() {
//        Map<String, Optional<Person>>
        Map<City, Optional<Person>> collectMax = persons.stream()
                        .collect(groupingBy(Person::getCity, maxBy(comparingInt(Person::getAge))));

        Map<City, Optional<Person>> collectMin = persons.stream()
                        .collect(groupingBy(Person::getCity, minBy(comparingInt(Person::getAge))));

        System.out.println(collectMax);
        System.out.println(collectMin);
    }


    // Getting a Summary for an Attribute of Grouped Results
    @Test
    public void name2() {

//        Map<String, IntSummaryStatistics>
        Map<City, IntSummaryStatistics> collect = persons.stream()
                        .collect(groupingBy(Person::getCity, summarizingInt(Person::getAge)));

        System.out.println(collect);
    }

    // Modifying the Return Map Type
    @Test
    public void name3() {
//        EnumMap<City, List<Person>>
        EnumMap<City, List<Person>> collect = persons.stream().collect(groupingBy(Person::getCity, () -> new EnumMap<>(City.class), toList()));

        System.out.println(collect);
        
    }

    // younger and older that 30 in same map
    @Test
    public void name5() {
        //        Map<Boolean, List<Person>> 

        Map<Boolean, List<Person>> collect = persons.stream()
                        .collect(Collectors.partitioningBy(p -> p.getAge() < 30, toList()));

        System.out.println(collect);
        
        

    }

    //average int
    @Test
    public void name6() {
        Double collect = persons.stream()
                        .collect(Collectors.averagingInt(Person::getAge));
        
        System.out.println(collect);
                                
    }

    //resolve key duplication !!!!
    // 
    @Test
    public void name7() {
    }

    @Test
    public void name() {
//        .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
//        .reduce((str1, str2) -> str1 + "-" + str2)
//        .reduce(0, (element1, element2) -> element1 + element2)

        int i = IntStream.range(2, 8).reduce((num1, num2) -> num1 * num2).orElse(-1);

        System.out.println(i);
    }
}