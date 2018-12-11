package com.globallogic.procamp.lesson12;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.DistinctResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.procamp.lesson12.data.EmployeeData;
import com.globallogic.procamp.lesson12.data.LocationData;
import com.globallogic.procamp.lesson12.data.SkillData;
import com.globallogic.procamp.lesson12.data.TaskData;
import com.globallogic.procamp.lesson12.data.TaskInfo;
import com.globallogic.procamp.lesson12.dto.CityEmployeeInfo;
import com.globallogic.procamp.lesson12.entity.EmployeeEntity;
import com.globallogic.procamp.lesson12.entity.LocationEntity;
import com.globallogic.procamp.lesson12.entity.SkillEntity;
import com.globallogic.procamp.lesson12.entity.TaskEntity;
import com.globallogic.procamp.lesson12.repository.AddressRepository;
import com.globallogic.procamp.lesson12.repository.BaseRepository;
import com.globallogic.procamp.lesson12.repository.EmployeeRepository;
import com.globallogic.procamp.lesson12.repository.LocationRepository;
import com.globallogic.procamp.lesson12.repository.SkillRepository;
import com.globallogic.procamp.lesson12.repository.TaskRepository;
import com.globallogic.procamp.lesson12.tasks.BaseRunner;

@Transactional
@Commit
public class Examples extends BaseRunner {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
//    @Transactional(readOnly = true)
    public void findLazy() {
/*      1 get entity */
        SkillEntity skill = skillRepository.findOne(1L);

/*      2 get entity call method*/
//        skill.getEmployee();
        
/*      3 get SQL :( */
//        skill.getEmployee().getName();
        
/*          4 example and explanation of n+1 problem
            n+1 */
//        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        
//        int size = 0;
        
//        for (EmployeeEntity employeeEntity : employeeEntities) {
//            size += employeeEntity.getTasks().size();
//        }

/*          5 simple example how calc size of collection        
            @LazyCollection(LazyCollectionOption.EXTRA) */
//        List<EmployeeEntity> entity = employeeRepository.findAll(Arrays.asList(1L, 2L));
//        System.out.println(entity.getTasks().size());

//        for (EmployeeEntity employeeEntity : entity) {
//            for (TaskEntity task : employeeEntity.getTasks()) {
//                task.getDescription();
//            }    
//        }
        
        
/* 
       6 dirty checking 
       org.hibernate.event.internal.DefaultFlushEntityEventListener#dirtyCheck
       org.hibernate.type.TypeHelper.findDirty(org.hibernate.tuple.NonIdentifierAttribute[], java.lang.Object[], java.lang.Object[], boolean[][], org.hibernate.engine.spi.SharedSessionContractImplementor)
       
       https://vladmihalcea.com/how-to-customize-hibernate-dirty-checking-mechanism/
       https://stackoverflow.com/questions/13539213/why-do-i-need-transaction-in-hibernate-for-read-only-operations
        
      @Transactional(readOnly = true)
      @Immutable
      sessin create query setReadOnly 
      statless session  !!! Danger
       */

/*        7 update one field, all field exist in query
            @DynamicUpdate
            @DynamicInsert
             PrepareStatement count !!!!!
             */
//        skill.setYears(2018);
    }

    @Test
    public void relationshipOwner() {
        // need to link objects
        // /*(mappedBy = "employee")*/
        EmployeeEntity employee = new EmployeeEntity("Andrii");
        TaskEntity taskEntity = new TaskEntity("Refactoring", 10);

        employee.addTask(taskEntity);
//        employee.getTasks().add(taskEntity);
//        taskEntity.setEmployee(employee);
        
        employeeRepository.save(employee);

        taskRepository.save(taskEntity);
    }

    @Test
    public void listVsSetBidirectional() {
        // 1. List<TaskEntity> tasks
        // 2. Set<TaskEntity> tasks
        EmployeeEntity employee = employeeRepository.findOne(1L);
        TaskEntity taskEntity = new TaskEntity("test", 1);
        employee.getTasks().add(taskEntity);
        taskRepository.save(taskEntity);
    }

    @Test
    public void equalsAndHashCodePitfall() {
        // V12__equals_and_hashcode_pitfall.sql
        // 1. validEquals
        // 2. invalidEquals
        EmployeeEntity employee = employeeRepository.findOne(1L);
        TaskEntity task = taskRepository.findOne(2L);

        boolean res = employee.equals(task.getEmployee());
        System.out.println(res);
    }

    @Test
    public void oneToOneLazyDoesNotWork() {
        // 1. @PrimaryKeyJoinColumn + optional=false
        // 2. @MapsId
        // 3. @LazyToOne(LazyToOneOption.NO_PROXY)
        // 4. V13one_to_one_join_table.sql
        EmployeeEntity employee = employeeRepository.findOne(1L);
        //        LocationEntity location = locationRepository.findOne(1L);
    }

    @Test
    public void eagerIsEvil() {
        // change fetch for tasks from LAZY to EAGER
        // 1. run 1 - observe join
        // 2. run 2 - observe additional queries (implicit N+1)
                employeeRepository.findOne(1L); // 1
//        employeeRepository.findAll(Arrays.asList(1L, 2L)); // 2
    }

/*
    @Test
    public void where() {
        // @Where
        employeeRepository.findOne(1L).getHighPriorityTasks().size();
    }

    @Test
    public void filter() {
        // @Filter
        Session session = em.unwrap(Session.class);
        session.enableFilter("priorityTasks").setParameter("highPriority", 0);
        employeeRepository.findOne(1L).getPriorityTasks().size();
        session.disableFilter("priorityTasks");
    }

    @Test
    public void formulaAndColumnTransformer() {
        // @Formula, @ColumnTransformer
        EmployeeEntity employee = employeeRepository.findOne(1L);
        System.out.println("Salary USD=" + employee.getSalary() + ", EUR=" + employee.getSalaryEur());
        System.out.println("Salary - Experience: " + employee.getSalaryExperience());
    }
  */  
    
 /* @Test
  public void showBatching() {
    // 1. run with disabled batching (hibernate.jdbc.batch_size) 
    // 2. show BatchingBatch logs
    // 3. enable hibernate.jdbc.batch_size=50
    // 4. show logs again
    // 5. uncomment newTask
    // 6. show console logs
    // 7. uncomment hibernate.order_inserts, hibernate.order_updates
    // 8. show console logs again
    int batchSize = 0;
    for (int i = 0; i < 100; i++) {
      EmployeeEntity employeeEntity = new EmployeeEntity();
      employeeEntity.setName("new name");
      em.persist(employeeEntity);

    TaskEntity newTask = new TaskEntity();
    newTask.setDescription("some description");
    employeeEntity.addTask(newTask);
//        employeeEntity.getTasks().add(newTask);
//        newTask.setEmployee(employeeEntity);
    em.persist(newTask);

      if (batchSize++ % 50 == 0) { // the same size as jdbc.batch_size
        em.flush();
        em.clear();
      }
    }
  }
    */

    @Test
    public void showTransformerConstructor() {
        //noinspection unchecked
        List<CityEmployeeInfo> res = em.createQuery("select new " +
                        "com.globallogic.procamp.lesson12.dto.CityEmployeeInfo(e.location.city, count(e)) from EmployeeEntity e " +
                        "group by e.location.city", CityEmployeeInfo.class)
                        .getResultList();
        res.forEach(System.out::println);
    }

    /*
        ResultSet transformer
     */
    @Test
    public void showAliasToBeanTransformer() {
        //noinspection unchecked
        List<CityEmployeeInfo> res = em.unwrap(Session.class)
                        .createQuery("select " +
                                        "e.location.city as city," +
                                        "count(e) as employees from EmployeeEntity e " +
                                        "group by e.location.city")
                        .setResultTransformer(Transformers.aliasToBean(CityEmployeeInfo.class))
                        .list();
        res.forEach(System.out::println);
    }

    @Test
    public void dto() {
        //noinspection unchecked
        List<EmployeeData> employeeDataList = em.unwrap(Session.class).createQuery("select " +
                        "e.id as employeeId, " +
                        "  e.name as employeeName, e.salary as employeeSalary, " +
                        "t.estimate as taskEstimate, t.description as taskDescription, " +
                        "a.id as locationId, a.city as locationCity " +
                        "from EmployeeEntity e " +
                        "left join e.tasks t " +
                        "left join e.location a")
                        .setResultTransformer(new EmployeeDataTransformer()).list();

        List<Long> employeeIds = employeeDataList.stream().map(EmployeeData::getId).collect(toList());
        if (!employeeIds.isEmpty()) {
            List<SkillData> skillData = em.createQuery("select new com.globallogic.procamp.lesson12.data.SkillData(s.title,s.years, s.employee.id) from SkillEntity s" +
                            " where s.id in :ids", SkillData.class)
                            .setParameter("ids", employeeIds)
                            .getResultList();
            populateSkills(employeeDataList, skillData);
        }
        employeeDataList.forEach(System.out::println);
    }

    private void populateSkills(List<EmployeeData> employeeDataList, List<SkillData> skillData) {
        Map<Long, List<SkillData>> skillMap = skillData.stream().collect(groupingBy(SkillData::getEmployeeId));
        employeeDataList.forEach(employeeData -> {
            List<SkillData> skills = skillMap.get(employeeData.getId());
            if (skills != null) {
                employeeData.setSkillData(skills);
            }
        });
    }


    private static class EmployeeDataTransformer implements ResultTransformer {

        private Map<String, EmployeeData> map = new HashMap<>();

        @Override
        public Object transformTuple(Object[] tuple, String[] aliases) {
            Assert.assertEquals("employeeId", aliases[0]);
            Assert.assertEquals("employeeName", aliases[1]);
            Assert.assertEquals("employeeSalary", aliases[2]);
            Assert.assertEquals("taskEstimate", aliases[3]);
            Assert.assertEquals("taskDescription", aliases[4]);
            Assert.assertEquals("locationId", aliases[5]);
            Assert.assertEquals("locationCity", aliases[6]);

            Long employeeId = (Long) tuple[0];
            String employeeName = (String) tuple[1];
            int employeeSalary = (int) tuple[2];
            EmployeeData employeeData = new EmployeeData(employeeId, employeeName, employeeSalary);

            EmployeeData alreadyEmployee = map.get(employeeName);
            if (alreadyEmployee == null) {
                alreadyEmployee = employeeData;
                map.put(employeeName, alreadyEmployee);
            }

            addTaskData(tuple, alreadyEmployee);
            addAddressData(tuple, alreadyEmployee);
            return alreadyEmployee;
        }

        private void addTaskData(Object[] tuple, EmployeeData alreadyEmployee) {
            Integer estimate = (Integer) tuple[3];
            String description = (String) tuple[4];
            if (!(estimate == null && description == null)) {
                TaskData taskData = new TaskData(estimate, description);
                alreadyEmployee.addTask(taskData);
            }
        }

        private void addAddressData(Object[] tuple, EmployeeData alreadyEmployee) {
            Long id = (Long) tuple[5];
            String city = (String) tuple[6];
            if (!(id == null && city == null)) {
                LocationData locationData = new LocationData(id, city);
                alreadyEmployee.setLocationData(locationData);
            }
        }

        @Override
        public List transformList(List collection) {
            return DistinctResultTransformer.INSTANCE.transformList(collection);
        }

    }

    @Test
    // todo location problem
    public void hibernateParsesHqlQueriesButDoesNotSql() {
        EmployeeEntity employee = employeeRepository.findOne(1L);
        employee.setName("new name");
        // see the difference in sql logs
        em.createQuery("select e from EmployeeEntity e", EmployeeEntity.class).getResultList();
//        em.createNativeQuery("select e.*, ea.id_location from employee e " +
//                        "join employee_location ea on e.id_employee = ea.id_employee")
//                        .getResultList();
    }

    @Test
    public void nativeQueryAllColumns() {
        List employees = em.createNativeQuery("SELECT " +
                                        "e.ID_EMPLOYEE " +
                                        ",e.NAME " +
                                        ",e.EXPERIENCE " +
                                        ",ea.id_location, " +
                                        //",e.SALARY " + //will fail due to not all fields are filled
                                        "e.salary " +
                                        "FROM Employee e " +
                                        "JOIN employee_location ea ON e.id_employee = ea.id_employee",
                        EmployeeEntity.class)
                        .getResultList();
    }

    @Test
    public void nativeSqlInFile() {
        em.createNativeQuery("SET @exp=:exp")
                        .setParameter("exp", 12).executeUpdate();
        List<EmployeeEntity> employees = em.createNamedQuery("findEmployeesWithExperienceGt",
                        EmployeeEntity.class)
                        .getResultList();
        employees.forEach(e -> System.out.println(e.getExperience()));
    }

    @Test
    public void nativeQueryInView() {
        SQLQuery query = em.unwrap(Session.class)
                        .createSQLQuery("SELECT * FROM max_employee_task_v");
        query.addEntity(TaskEntity.class);
        query.list();
    }

    @Test
    public void joinNative() {
        SQLQuery query = em.unwrap(Session.class)
                        .createSQLQuery("SELECT e.id_employee, e.name, e.experience, e.salary, 1 AS id_location" +
                                        "LEFT JOIN task t ON e.id_employee = t.id_employee");
        query.addEntity("e", EmployeeEntity.class);
        query.addEntity("t", TaskEntity.class);
        List<Object[]> res = query.list();
        for (Object[] re : res) {
            EmployeeEntity employee = (EmployeeEntity) re[0];
            TaskEntity task = (TaskEntity) re[1];
        }
    }

    @Test
    public void mappingNativeToDto() {
        //noinspection unchecked
        List<TaskInfo> list = em.unwrap(Session.class).createSQLQuery("SELECT * FROM TASKS_BY_EMPLOYEE_V")
                        .addScalar("name", StandardBasicTypes.STRING)
                        .addScalar("tasks", StandardBasicTypes.INTEGER)
                        .setResultTransformer(Transformers.aliasToBean(TaskInfo.class))
                        .list();
        list.forEach(System.out::println);
    }

    @Test
    public void nativeSqlJoinFetch() {
        SQLQuery query = em.unwrap(Session.class)
                        .createSQLQuery("SELECT e.id_employee, e.name, e.experience, e.salary, 1 AS id_location" +
                                        ", t.id_task, t.description, t.estimate, t.high_priority, t.create_date, t.modify_date, t.id_employee " +
                                        "FROM employee e" +
                                        " JOIN task t ON e.id_employee = t.id_employee");
        query.addEntity("e", EmployeeEntity.class);
        // Declare a join fetch result.
        query.addFetch("t", "e", "tasks");
        Set<EmployeeEntity> employees = new HashSet<>();
        //noinspection unchecked
        List<Object[]> list = query.list();
        for (Object[] object : list) {
            EmployeeEntity employee = (EmployeeEntity) object[0];
            employees.add(employee);
        }
        em.clear();
        employees.forEach(e -> e.getTasks().size());
//        employees.stream().forEach(e -> e.getSkills().size());
    }


}
