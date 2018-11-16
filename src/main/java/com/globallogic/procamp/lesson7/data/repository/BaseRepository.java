package com.globallogic.procamp.lesson7.data.repository;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T, ID extends Serializable> {
  T findOne(ID id);

  List<T> findAll();

  List<T> findAll(List<Long> ids);

  T save(T entity);

  void delete(T entity);

  void delete(ID id);

  long count();

  void flush();

  void clear();
}
