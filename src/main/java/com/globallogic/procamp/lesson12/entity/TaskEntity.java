package com.globallogic.procamp.lesson12.entity;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@FilterDef(name = "priorityTasks",
                parameters = @ParamDef(name = "highPriority", type = "integer")
)
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq")
    @Column(name = "id_task")
    private Long id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "estimate")
    private Integer estimate;

    @Column(name = "high_priority")
    private boolean highPriority;

    @Column(name = "create_date")
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "modify_date")
    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date modifyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employee;

    public TaskEntity(String description, int estimate) {
        this.description = description;
        this.estimate = estimate;
    }

}