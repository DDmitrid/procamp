package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.procamp.lesson12.entity.onetoone.unidirectional.PersonEntity;
import com.globallogic.procamp.lesson12.repository.BaseRepositoryImpl;
import com.globallogic.procamp.lesson12.repository.onetoone.unidirectional.PersonRepository;

@Repository
@Transactional
public class PersonRepositoryImpl extends BaseRepositoryImpl<PersonEntity, Long> implements PersonRepository {

}
