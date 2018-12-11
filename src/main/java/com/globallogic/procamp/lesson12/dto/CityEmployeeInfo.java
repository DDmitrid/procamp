package com.globallogic.procamp.lesson12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // just for ResultSetTransformer
public class CityEmployeeInfo {
  private String city;
  private long employees;
}
