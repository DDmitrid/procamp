CREATE SEQUENCE car_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE car (
  id      NUMBER(19) DEFAULT car_seq.nextval PRIMARY KEY,
  name   VARCHAR(100) NOT NULL
);

CREATE SEQUENCE driver_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE driver (
  id      NUMBER(19) DEFAULT driver_seq.nextval PRIMARY KEY,
  name   VARCHAR(100) NOT NULL
);


CREATE TABLE car_driver (
  id_car NUMBER(19) PRIMARY KEY,
  id_driver NUMBER(19) NOT NULL,
  CONSTRAINT fk_car FOREIGN KEY (id_car)
  REFERENCES car(id),
  CONSTRAINT fk_driver FOREIGN KEY (id_driver)
  REFERENCES driver(id),
  CONSTRAINT unique_driver unique (id_driver)
);