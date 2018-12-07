package com.globallogic.procamp.lesson12.repository.onetoone.unidirectional;

import com.globallogic.procamp.lesson12.entity.onetoone.unidirectional.PersonEntity;
import com.globallogic.procamp.lesson12.repository.BaseRepository;

public interface PersonRepository  extends BaseRepository<PersonEntity, Long> {
}
