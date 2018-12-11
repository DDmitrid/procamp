package com.globallogic.procamp.lesson12.repository;

import com.globallogic.procamp.lesson12.entity.TaskEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class TaskRepositoryImpl extends BaseRepositoryImpl<TaskEntity, Long> implements TaskRepository {
}