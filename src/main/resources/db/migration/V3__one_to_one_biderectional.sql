-- accountEntity
CREATE SEQUENCE account_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE account (
  id_account  NUMBER(19) DEFAULT account_seq.nextval PRIMARY KEY,
  account_no      VARCHAR(100) NOT NULL,
  id_customer   NUMBER(19)  NOT NULL,
  CONSTRAINT fk_customer_account FOREIGN KEY (id_account)
  REFERENCES account (id_account),
  CONSTRAINT customer_account_uq UNIQUE (id_account)
);

CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE customer (
  id_customer   NUMBER(19) DEFAULT customer_seq.nextval PRIMARY KEY,
  name        VARCHAR(100) NOT NULL
);