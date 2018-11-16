package com.globallogic.procamp.lesson7.data.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class BaseRepositoryImpl<T, ID extends Serializable> implements BaseRepository<T, ID> {

  @PersistenceContext
  protected EntityManager em;
  protected Class<T> entityClass;
  private Class<ID> id;

  BaseRepositoryImpl() {
    ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
    Type[] args = genericSuperclass.getActualTypeArguments();
    //noinspection unchecked
    this.entityClass = (Class<T>) args[0];
    //noinspection unchecked
    this.id = (Class<ID>) args[1];
  }

  protected Session getSession() {
    return em.unwrap(Session.class);
  }

  @Override
  public T findOne(ID id) {
    return em.find(entityClass, id);
  }

  @Override
  public T save(T entity) {
    Object id = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
    if (id == null) {
      em.persist(entity);
      return entity;
    } else {
      return em.merge(entity);
    }
  }

  @Override
  public void flush() {
    em.flush();
  }

  @Override
  public void clear() {
    em.clear();
  }

  @Override
  public List<T> findAll(List<Long> ids) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> query = cb.createQuery(entityClass);
    Root<T> from = query.from(entityClass);
    query.where(from.get("id").in(ids));
    return em.createQuery(query.select(from)).getResultList();
  }

  @Override
  public long count() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery query = cb.createQuery(id);
    //noinspection unchecked
    query.select(cb.count(query.from(entityClass)));
    return (long) em.createQuery(query).getSingleResult();
  }

  @Override
  public List<T> findAll() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> query = cb.createQuery(entityClass);
    Root<T> from = query.from(entityClass);
    return em.createQuery(query.select(from)).getResultList();
  }

  @Override
  public void delete(T entity) {
    em.remove(entity);
  }

  @Override
  public void delete(ID id) {
    T entity = em.find(entityClass, id);
    em.remove(entity);
  }
}
