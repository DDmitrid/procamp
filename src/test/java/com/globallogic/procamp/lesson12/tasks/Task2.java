package com.globallogic.procamp.lesson12.tasks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.procamp.lesson12.entity.EmployeeEntity;
import com.globallogic.procamp.lesson12.entity.TaskEntity;
import com.globallogic.procamp.lesson12.repository.EmployeeRepository;

@Transactional
@Commit
/*
    Найти самых опытных сотрудников, c паджинацией, 
    у которых зарплата строго больше 5500.
    
//    На выходе должны получить объекты класса Employee со всеми полями,
//    включая и дочерние – tasks, skills, address.
 */
public class Task2 extends BaseRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void task2() {
        int offset = 0;
        int pageSize = 1;
        int salary = 5500;
        List<EmployeeEntity> employees = employeeRepository.findTheMostExperiencedEmployeesWithSalaryGt(salary, offset, pageSize);
        //employees.forEach(System.out::println);
        assertThat(employees.size(), is(1));
        EmployeeEntity employee = employees.get(0);
        assertThat(employee.getId(), is(notNullValue()));
        assertThat(employee.getName(), is(notNullValue()));
        assertThat(employee.getExperience(), is(not(0)));
//        assertThat(employee.getSkills().size(), is(not(0)));
//        assertThat(employee.getTasks().size(), is(not(0)));
//        assertThat(employee.getLocation(), is(notNullValue()));
//        for (EmployeeEntity e : employees) {
//            for (TaskEntity task : e.getTasks()) {
//                task.getDescription();
//
//            }
//        }
        
    }
}
