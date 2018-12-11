package com.globallogic.procamp.lesson12.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.globallogic.procamp.lesson12.dto.EmployeeSearchCriteriaDto;
import com.globallogic.procamp.lesson12.entity.EmployeeEntity;
import com.globallogic.procamp.lesson12.entity.EmployeeEntity_;

import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<EmployeeEntity, Long> implements EmployeeRepository {

    @Override
    public List<EmployeeEntity> findTheMostExperiencedEmployeesWithSalaryGt(int salary, int offset, int pageSize) {
        return findTheMostExperiencedEmployeesJoinFetch(salary, offset, pageSize);
    }

    private List<EmployeeEntity> findTheMostExperiencedEmployeesJoinFetch(int salary, int offset, int pageSize) {
        return em.createQuery("select e from EmployeeEntity e " +
                        "join fetch e.location " +
//                        "join e.skills " +
                        "join fetch e.tasks " +
                        "where e.salary > :salary " +
                        "order by e.experience desc", EmployeeEntity.class)
                        .setParameter("salary", salary)
                        .setFirstResult(offset)
                        .setMaxResults(pageSize)
                        .getResultList();   
    }
    
    private List<EmployeeEntity> findTheMostExperiencedEmployeesFetchGraph(int salary, int offset, int pageSize) {
        return query1()
                        .setHint(QueryHints.HINT_FETCHGRAPH, em.getEntityGraph(EmployeeEntity.LOCATION_GRAPH))
                        .setParameter("salary", salary)
                        .setFirstResult(offset)
                        .setMaxResults(pageSize)
                        .getResultList();    
    }

    private List<EmployeeEntity> findTheMostExperiencedEmployeesChainOfQueries(int salary, int offset, int pageSize) {
        List<Long> ids = em.createQuery("select e.id from EmployeeEntity e " +
                        " where e.salary > :salary order by e.experience desc", Long.class)
                        .setParameter("salary", salary)
                        .setFirstResult(offset)
                        .setMaxResults(pageSize)
                        .getResultList();

        return em.createQuery("select distinct e from EmployeeEntity e " +
                        " left join fetch e.location " +
                        " left join fetch e.tasks " +
                        " where e.id in :ids" +
                        " order by e.experience desc", EmployeeEntity.class)
                        .setParameter("ids", ids)
                        .getResultList();
        
    }
    

    
  
   private TypedQuery<EmployeeEntity> query1() {
    return em.createQuery("select e from EmployeeEntity e " +
                //"join fetch e.location " +
                "join fetch e.skills " +
                "where e.salary > :salary order by e.experience desc", EmployeeEntity.class);
  }

    private TypedQuery<EmployeeEntity> query() {
        return em.createQuery("select e from EmployeeEntity e " +
                //"join fetch e.location " +
                "join fetch e.skills " +
                "where e.salary > :salary order by e.experience desc", EmployeeEntity.class);
    }

    @Override
    public Map<String, Long> getEmployeeCountByCountry() {
        return solutionGood();
    }

    private Map<String, Long> solutionUgly() {
        Map<String, Long> map = new HashMap<>();
        List<EmployeeEntity> employees = em.createQuery("select e from EmployeeEntity e", EmployeeEntity.class).getResultList();
        for (EmployeeEntity employee : employees) {
            String city = employee.getLocation().getCity();
            Long count = map.get(city);
            if (count == null) {
                count = 0L;
            }
            map.put(city, ++count);

//            map.merge(city, 1L, Long::sum);
        }
        return map;
    }

    private Map<String, Long> solutionBad() {
        Map<String, Long> map = new HashMap<>();
        List<EmployeeEntity> employees = em.createQuery("select e from EmployeeEntity e join fetch e.location", EmployeeEntity.class).getResultList();
        for (EmployeeEntity employee : employees) {
            String city = employee.getLocation().getCity();
            Long count = map.get(city);
            if (count == null) {
                count = 0L;
            }
            map.put(city, ++count);
        }
        return map;
    }

    private Map<String, Long> solutionGood() {
        Map<String, Long> map = new HashMap<>();
        List<Object[]> res = em.createQuery("select e.location.city, count(e) " +
                        "from EmployeeEntity " +
                        "e group by e.location.city")
                        .getResultList();
        for (Object[] re : res) {
            map.put((String) re[0], (Long) re[1]);
        }
        return map;
    }

    @Override
    public List<EmployeeEntity> search(EmployeeSearchCriteriaDto search, int offset, int pageSize) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = cb.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> from = query.from(EmployeeEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (search.getExperience() != null) {
            predicates.add(cb.greaterThanOrEqualTo(from.get(EmployeeEntity_.experience), search.getExperience()));
        }

        if (search.getName() != null) {
            predicates.add(cb.like(from.get(EmployeeEntity_.name), "%" + search.getName() + "%"));
        }

        query.select(from).where(predicates.toArray(new Predicate[predicates.size()]));

        return em.createQuery(query)
                        .setFirstResult(offset)
                        .setMaxResults(pageSize)
                        .getResultList();
    }


}
