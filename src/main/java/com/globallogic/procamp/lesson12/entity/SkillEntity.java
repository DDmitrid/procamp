package com.globallogic.procamp.lesson12.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill")
@Getter
@Setter
//@Immutable
//@DynamicUpdate
//@DynamicInsert
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
    @SequenceGenerator(name = "skill_seq", sequenceName = "skill_seq")
    @Column(name = "id_skill")
    private Long id;

    @Column(name = "title")
    @NotNull
    @Enumerated(EnumType.STRING)
    private SkillTitle title;

    @Column(name = "years")
    private int years = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employee;

}
