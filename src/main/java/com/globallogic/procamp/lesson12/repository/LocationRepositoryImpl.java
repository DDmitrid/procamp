package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.procamp.lesson12.entity.LocationEntity;

@Repository
@Transactional
public class LocationRepositoryImpl extends BaseRepositoryImpl<LocationEntity, Long> implements LocationRepository {
}
