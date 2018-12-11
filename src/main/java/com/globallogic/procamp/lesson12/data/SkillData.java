package com.globallogic.procamp.lesson12.data;

import com.globallogic.procamp.lesson12.entity.SkillTitle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SkillData {
  private SkillTitle skillTitle;
  private int years;
  private Long employeeId;
}
