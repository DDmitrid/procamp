package com.globallogic.procamp.lesson12.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

public class EmployeeData {
  private Long id;
  private final Long employeeId;
  private final String employeeName;
  private final int employeeSalary;
  private List<TaskData> tasks = new ArrayList();
  private List<SkillData> skills = new ArrayList<>();

  @Setter
  private LocationData locationData;

  public EmployeeData(Long employeeId, String employeeName, int employeeSalary) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.employeeSalary = employeeSalary;
  }

  public void addTask(TaskData taskData) {
    this.tasks.add(taskData);
  }

  public void setLocationData(LocationData locationData) {
    this.locationData = locationData;
  }

  public void setSkillData(List<SkillData> skills) {
    this.skills = skills;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
