package com.globallogic.procamp.lesson12.tasks;


import com.globallogic.procamp.lesson12.entity.EmployeeEntity;
import com.globallogic.procamp.lesson12.entity.LocationEntity;
import com.globallogic.procamp.lesson12.entity.SkillEntity;
import com.globallogic.procamp.lesson12.entity.TaskEntity;
import com.globallogic.procamp.lesson12.repository.AddressRepository;
import com.globallogic.procamp.lesson12.repository.EmployeeRepository;
import com.globallogic.procamp.lesson12.repository.LocationRepository;
import com.globallogic.procamp.lesson12.repository.SkillRepository;
import com.globallogic.procamp.lesson12.repository.TaskRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Transactional
@Commit
public class Task1 extends BaseRunner {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  SkillRepository skillRepository;

  @Autowired
  TaskRepository taskRepository;

  @Autowired 
  LocationRepository locationRepository;

  @Test
  public void shouldGetAddress() {
    LocationEntity address = locationRepository.findOne(1L);
    assertThat(address, is(notNullValue()));
  }

  @Test
  public void shouldGetEmployee() {
    EmployeeEntity employee = employeeRepository.findOne(1L);
    assertThat(employee, is(notNullValue()));
  }

  @Test
  public void shouldGetSkill() {
    SkillEntity skill = skillRepository.findOne(1L);
    assertThat(skill, is(notNullValue()));
  }

  @Test
  public void shouldGetTask() {
    TaskEntity task = taskRepository.findOne(1L);
    assertThat(task, is(notNullValue()));
  }
}
