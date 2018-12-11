package com.globallogic.procamp.lesson12.repository;

import com.globallogic.procamp.lesson12.entity.SkillEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class SkillRepositoryImpl extends BaseRepositoryImpl<SkillEntity, Long> implements SkillRepository {
}
