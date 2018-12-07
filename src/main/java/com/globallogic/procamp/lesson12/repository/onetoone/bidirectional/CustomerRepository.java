package com.globallogic.procamp.lesson12.repository.onetoone.bidirectional;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.CustomerEntity;
import com.globallogic.procamp.lesson12.repository.BaseRepository;
import com.globallogic.procamp.lesson12.repository.BaseRepositoryImpl;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Long> {
}
