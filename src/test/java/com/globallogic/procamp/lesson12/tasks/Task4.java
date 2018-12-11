package com.globallogic.procamp.lesson12.tasks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.procamp.lesson12.repository.EmployeeRepository;
/*
    Получить кол-во сотрудников по городам. На выходе получить Map<String, Long>, где
    ключ – название города, значение – кол-во сотрудников.
 */
public class Task4 extends BaseRunner {
  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void task4() {
    Map<String, Long> countryCountEmployee = employeeRepository.getEmployeeCountByCountry();
    assertThat(countryCountEmployee.get("San Francisco"), is(50L));
    assertThat(countryCountEmployee.get("Delhi"), is(50L));
    assertThat(countryCountEmployee.get("Rome"), is(50L));
    assertThat(countryCountEmployee.get("Seattle"), is(50L));
    assertThat(countryCountEmployee.get("Tokyo"), is(50L));
    assertThat(countryCountEmployee.get("Barcelona"), is(50L));
    assertThat(countryCountEmployee.get("Amsterdam"), is(50L));
    assertThat(countryCountEmployee.get("London"), is(50L));
    assertThat(countryCountEmployee.get("Paris"), is(50L));
    assertThat(countryCountEmployee.get("Toronto"), is(50L));
  }

}
