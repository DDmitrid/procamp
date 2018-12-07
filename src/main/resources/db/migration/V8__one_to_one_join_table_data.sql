INSERT INTO car (id, name) VALUES (car_seq.nextval, 'Renault');
INSERT INTO car (id, name) VALUES (car_seq.nextval, 'BMW');


INSERT INTO driver (id, name) VALUES (driver_seq.nextval, 'Andrii Sivachok');
INSERT INTO driver (id, name) VALUES (driver_seq.nextval,  'Michael Schumacher');


INSERT INTO car_driver (id_car, id_driver) VALUES (1, 2);
INSERT INTO car_driver (id_car, id_driver) VALUES (2, 1);
