package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.jointable.Driver;
import com.globallogic.procamp.lesson12.repository.onetoone.jointable.DriverRepository;

@Repository
public class DriverRepositoryImpl extends BaseRepositoryImpl<Driver, Long> implements DriverRepository {
    
}
