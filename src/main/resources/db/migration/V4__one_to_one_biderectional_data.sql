INSERT INTO customer (id_customer, name) VALUES (customer_seq.nextval, 'HP');
INSERT INTO customer (id_customer, name) VALUES (customer_seq.nextval, 'Cisco');


INSERT INTO account (id_account, account_no, id_customer) VALUES (account_seq.nextval, '0001', 1);
INSERT INTO account (id_account, account_no, id_customer) VALUES (account_seq.nextval, '0002', 2);

