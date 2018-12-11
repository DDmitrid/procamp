create or replace view tasks_by_employee_v as
  select name, count(*) as tasks from employee e
    join task t on e.id_employee = t.id_employee
  group by e.id_employee, e.name;