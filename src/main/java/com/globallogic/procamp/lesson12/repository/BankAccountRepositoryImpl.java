package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.BankAccountEntity;
import com.globallogic.procamp.lesson12.repository.onetoone.bidirectional.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl extends BaseRepositoryImpl<BankAccountEntity, Long> implements BankAccountRepository {
}
