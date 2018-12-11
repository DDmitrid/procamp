package com.globallogic.procamp.lesson12.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
//@NamedEntityGraphs({
//                @NamedEntityGraph(name = EmployeeEntity.LOCATION_GRAPH, attributeNodes = @NamedAttributeNode("location"))
//})

//@Immutable

public class EmployeeEntity {

    public static final String LOCATION_GRAPH = "EmployeeEntity[location]";

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq")
    @Column(name = "id_employee")
    @Getter
    private Long id;

    @Column(name = "name")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "experience")
    private int experience = 1;

    @Column(name = "salary")
    private Integer salary;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
    // 1. @PrimaryKeyJoinColumn + optional=false
    //@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", optional = false)
    // 2 
    // 3 REMOVE   , optional = false
    // @LazyToOne(LazyToOneOption.NO_PROXY)
    // 4 
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinTable(
//                    name = "employee_location",
//                    joinColumns =
//                    @JoinColumn(name = "id_employee"),
//                    inverseJoinColumns =
//                    @JoinColumn(name = "id_location",
//                                    unique = true)
//    )
    @Setter
    private LocationEntity location;

    @OneToMany(mappedBy = "employee"/*, orphanRemoval =  true*/)
//    @Fetch(FetchMode.SUBSELECT) 
//    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<TaskEntity> tasks = new ArrayList<>();

    public EmployeeEntity(String name) {
        this.name = name;
    }

    public void addTask(TaskEntity taskEntity) {
        tasks.add(taskEntity);
        taskEntity.setEmployee(this);
    }

    public void removeTask(TaskEntity taskEntity) {
        tasks.remove(taskEntity);
        taskEntity.setEmployee(null);
    }

    @OneToMany(mappedBy = "employee")
//    @Fetch(FetchMode.SUBSELECT)
    private List<SkillEntity> skills = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EmployeeEntity))
            return false;

        EmployeeEntity that = (EmployeeEntity) o;
        return validEquals(that);
    }

    private boolean invalidEquals(EmployeeEntity that) {
        System.out.println("This name " + name + " , that name " + that.name);
        return name != null ? name.equals(that.name) : that.name == null;
    }

    private boolean validEquals(EmployeeEntity this, EmployeeEntity that) {
        System.out.println("This name " + getName() + " , that name " + that.getName());
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

/*
    @Formula("salary ||' - '|| experience")
    @Getter
    private String salaryExperience;

    @ColumnTransformer(read = "salary * 0.9", write = "? / 0.9")
    @Getter
    private Integer salaryEur; // salary in EUR, default in USD;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @Filter(name = "priorityTasks", condition = "high_priority = :highPriority")
    @Getter
    private List<TaskEntity> priorityTasks = new ArrayList<>();

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @Getter
    @Where(clause = "high_priority = 1")
    private List<TaskEntity> highPriorityTasks = new ArrayList<>();
  */  
}

