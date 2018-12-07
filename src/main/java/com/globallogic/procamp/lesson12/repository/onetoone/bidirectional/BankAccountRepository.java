package com.globallogic.procamp.lesson12.repository.onetoone.bidirectional;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.BankAccountEntity;
import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.CustomerEntity;
import com.globallogic.procamp.lesson12.repository.BaseRepository;

@Repository
public interface BankAccountRepository extends BaseRepository<BankAccountEntity, Long> {
}
