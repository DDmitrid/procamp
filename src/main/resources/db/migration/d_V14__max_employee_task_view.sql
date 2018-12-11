create or replace view max_employee_task_v as
  select t.* from task t join(
             select t.id_employee, max(t.modify_date) mdate from task t
             group by t.id_employee) max_t
  on t.id_employee = max_t.id_employee and t.modify_date = max_t.mdate;