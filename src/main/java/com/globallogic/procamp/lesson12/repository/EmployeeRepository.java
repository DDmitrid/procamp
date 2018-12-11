package com.globallogic.procamp.lesson12.repository;


import java.util.List;
import java.util.Map;

import com.globallogic.procamp.lesson12.dto.EmployeeSearchCriteriaDto;
import com.globallogic.procamp.lesson12.entity.EmployeeEntity;



public interface EmployeeRepository extends BaseRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findTheMostExperiencedEmployeesWithSalaryGt(int salary, int offset, int pageSize);

    Map<String,Long> getEmployeeCountByCountry();

    List<EmployeeEntity> search(EmployeeSearchCriteriaDto search, int offset, int pageSize);


}
