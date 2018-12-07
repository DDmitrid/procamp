package com.globallogic.procamp.lesson12.entity.onetoone.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq")
    @Column(name = "id_account")
    private Long id;


    @Column(name = "account_no")
    @NotNull
    private String accountNo;

    @OneToOne
//    @PrimaryKeyJoinColumn
    @JoinColumn(name="id_customer")
    private CustomerEntity customer;
}
