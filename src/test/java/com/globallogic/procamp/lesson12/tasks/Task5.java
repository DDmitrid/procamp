package com.globallogic.procamp.lesson12.tasks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.procamp.lesson12.dto.EmployeeSearchCriteriaDto;
import com.globallogic.procamp.lesson12.entity.EmployeeEntity;
import com.globallogic.procamp.lesson12.repository.EmployeeRepository;

public class Task5 extends BaseRunner {

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void task5() {
    EmployeeSearchCriteriaDto search = new EmployeeSearchCriteriaDto();

    String name = "ert";
    int experience = 8;

    search.setName(name);
    search.setExperience(experience);
    int offset = 0;
    int pageSize = 10;
    List<EmployeeEntity> employees = employeeRepository.search(search, offset, pageSize);
    employees.forEach(System.out::println);
    assertThat(employees.stream().allMatch(emp -> emp.getExperience() >= experience), is(true));
    assertThat(employees.stream().allMatch(emp -> emp.getName().contains(name)), is(true));
  }
}
