DELETE FROM jaegers;
ALTER SEQUENCE jaegers_id_seq RESTART WITH 1;

INSERT INTO jaegers (model_name, mark, height, weight, status, origin, launch, kaiju_kill)
    VALUES
           ('Gipsy Danger', 'Mark-3', 79.25, 1.98, 'Destroyed', 'USA', '2017-07-10', 9),
           ('Striker Eureka', 'Mark-5', 76.2, 1.85, 'Destroyed', 'AUSTRALIA', '2019-11-2', 11),
           ('Cherno Alpha', 'Mark-1', 85.34, 2.412, 'Destroyed', 'RUSSIA', '2015-01-01', 6),
           ('Apex', null, null, null, 'Active', null, '2035-01-01', null),
           ('Atlas Destroyer', 'Mark-3', null, null, 'Active', null, '2017-01-01', 1),
           ('Gipsy Avenger', 'Mark-6', 81.77, 2.004, 'Destroyed', null, '2034-01-12', 1),
           ('Coyote Tango', 'Mark-1', 85.34, 2.312, 'Destroyed', 'Japan', '2015-12-30', 2),
           ('Black Maria', null, null, null, null, 'Mexico', null, null),
           ('Mammoth Apostle', 'Mark-4', null, null, 'Destroyed', 'USA', '2018-01-01', null),
           ('Chaos Nemesis', 'Mark-4', null, null, 'Destroyed', null, null, null);
