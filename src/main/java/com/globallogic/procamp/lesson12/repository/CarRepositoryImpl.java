package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.jointable.Car;
import com.globallogic.procamp.lesson12.repository.onetoone.jointable.CarRepository;

@Repository
public class CarRepositoryImpl extends BaseRepositoryImpl<Car, Long> implements CarRepository {
}
