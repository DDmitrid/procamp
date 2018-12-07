CREATE SEQUENCE post_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE post (
  id      NUMBER(19) DEFAULT post_seq.nextval PRIMARY KEY,
  title   VARCHAR(100) NOT NULL
);


CREATE TABLE post_details (
  created_by  VARCHAR(100) NOT NULL,
  post_id     NUMBER(19)

);