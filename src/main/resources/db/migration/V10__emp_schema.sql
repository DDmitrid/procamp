-- employee
CREATE SEQUENCE employee_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE employee (
  id_employee NUMBER(19) DEFAULT employee_seq.nextval PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  salary      NUMBER,
  experience  NUMBER       NOT NULL DEFAULT 1
);

-- locationEntity
CREATE SEQUENCE location_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE location (
  id_location  NUMBER(19) DEFAULT location_seq.nextval PRIMARY KEY,
  city        VARCHAR(100) NOT NULL,
  street      VARCHAR(100) NOT NULL,
  id_employee NUMBER(19)   NOT NULL,
  CONSTRAINT fk_location_employee FOREIGN KEY (id_employee)
  REFERENCES employee (id_employee),
  CONSTRAINT location_employee_uq UNIQUE (id_employee)
);

-- skill
CREATE SEQUENCE skill_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE skill (
  id_skill    NUMBER DEFAULT skill_seq.nextval PRIMARY KEY,
  title       VARCHAR(20) NOT NULL,
  years       NUMBER      NOT NULL DEFAULT 1,
  id_employee NUMBER(19)  NOT NULL,
  CONSTRAINT fk_skill_employee FOREIGN KEY (id_employee)
  REFERENCES employee (id_employee),
  CONSTRAINT skill_title_uq UNIQUE (id_employee, title)
);

-- task
CREATE SEQUENCE task_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE task (
  id_task       NUMBER(19) DEFAULT task_seq.nextval PRIMARY KEY,
  description   VARCHAR(255) NOT NULL,
  estimate      NUMBER,
  high_priority NUMBER(1)    NOT NULL DEFAULT 0,
  create_date   DATE         NOT NULL,
  modify_date   DATE,
  id_employee   NUMBER(19),
  CONSTRAINT fk_task_employee FOREIGN KEY (id_employee)
  REFERENCES employee (id_employee)
);