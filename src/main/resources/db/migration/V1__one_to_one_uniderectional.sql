-- addressEntity
CREATE SEQUENCE address_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE address (
  id_address  NUMBER(19) DEFAULT address_seq.nextval PRIMARY KEY,
  city        VARCHAR(100) NOT NULL,
  street      VARCHAR(100) NOT NULL
);

CREATE SEQUENCE person_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE person (
  id_person   NUMBER(19) DEFAULT person_seq.nextval PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  id_address  NUMBER(19)  NOT NULL,
  CONSTRAINT fk_person_address FOREIGN KEY (id_address)
  REFERENCES address (id_address),
  CONSTRAINT person_address_uq UNIQUE (id_address)
);