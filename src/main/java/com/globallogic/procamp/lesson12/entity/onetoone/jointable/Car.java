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
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_seq")
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(
                    name = "car_driver",
                    
                    joinColumns =
                    @JoinColumn(name = "id_car"),
                    
                    inverseJoinColumns =
                    @JoinColumn(name = "id_driver",
                                    unique = true)
    )
    private Driver driver;
}
