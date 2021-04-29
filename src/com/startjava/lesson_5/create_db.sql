-- DROP DATABASE IF EXISTS jaegers;
-- CREATE DATABASE jaegers;

CREATE TABLE IF NOT EXISTS jaegers (
    id SERIAL PRIMARY KEY ,
    model_name VARCHAR(20),
    mark VARCHAR(20),
    height DOUBLE PRECISION,
    weight DOUBLE PRECISION,
    status VARCHAR(20),
    origin VARCHAR(20),
    launch DATE,
    kaiju_kill integer
);
