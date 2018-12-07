package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.BankAccountEntity;
import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.CustomerEntity;
import com.globallogic.procamp.lesson12.repository.onetoone.bidirectional.BankAccountRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.bidirectional.CustomerRepository;
import com.globallogic.procamp.lesson7.data.repository.CustomRepository;

@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl<CustomerEntity, Long> implements CustomerRepository {
}
