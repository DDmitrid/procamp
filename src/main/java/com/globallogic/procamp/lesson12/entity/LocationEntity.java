package com.globallogic.procamp.lesson12.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @SequenceGenerator(name = "location_seq", sequenceName = "location_seq")
    @Column(name = "id_location")
    private Long id;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "street")
    @NotNull
    private String street;

    @OneToOne
    @JoinColumn(name = "id_employee")
// 1. @PrimaryKeyJoinColumn + optional=false
//     @PrimaryKeyJoinColumn
// 2 REMOVE @PrimaryKeyJoinColumn
//    @MapsId
// 3 REMOVE  @MapsId
// 4 
//    @OneToOne(fetch = FetchType.LAZY)    
// @JoinTable(
//      name = "employee_location",
//      joinColumns =
//      @JoinColumn(name = "id_location"),
//      inverseJoinColumns =
//      @JoinColumn(name = "id_employee",
//          unique = true)
//  )
  @Getter    
    
       @NotNull
    private EmployeeEntity employee;


}