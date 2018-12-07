package com.globallogic.procamp.lesson12.entity.onetoone.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_seq")
    @SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq")
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(
                    name = "car_driver",
                    joinColumns = 
                    @JoinColumn(name="id_driver"),
                    inverseJoinColumns = 
                    @JoinColumn(name = "id_car", unique = true)
    )
    private Car car;
}
