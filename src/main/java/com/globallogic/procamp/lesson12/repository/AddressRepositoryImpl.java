package com.globallogic.procamp.lesson12.repository;

import com.globallogic.procamp.lesson12.entity.onetoone.unidirectional.AddressEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class AddressRepositoryImpl extends BaseRepositoryImpl<AddressEntity, Long> implements AddressRepository {
}
