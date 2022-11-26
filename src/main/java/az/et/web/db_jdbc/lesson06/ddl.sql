-- SQL - Structured Query Language
-- RDMS -> 1.relation, 2.structure

-- DDL - Data Definition   Language -> structure
-- DML - Data Manipulation Language -> process

-- (CRUD) -> Create, Retrieve (read), Update, Delete (drop)


------------ DDL ------------

-- create db
CREATE DATABASE testDb;

-- read db
SHOW DATABASES; -- MySQL
SELECT datname
FROM pg_database;
-- Postgres

-- delete db
DROP DATABASE testDb;

-- create table
CREATE TABLE people2
(
    person_id  int,
    last_name  varchar(255),
    first_name varchar(255),
    address    varchar(255),
    city       varchar(255)
);

-- delete (drop)
DROP TABLE people2;

-- truncate table
TRUNCATE TABLE people;

-- update (alter)
ALTER TABLE people ADD age int;
ALTER TABLE people DROP address;
ALTER TABLE people ADD address varchar(255);
ALTER TABLE people ALTER COLUMN person_id TYPE bigint;
ALTER TABLE people ALTER COLUMN person_id TYPE float8;
ALTER TABLE people ALTER COLUMN person_id TYPE bigint;
ALTER TABLE people DROP age;
ALTER TABLE people ADD date_of_birth date;
ALTER TABLE people DROP date_of_birth;
ALTER TABLE people ADD date_of_birth timestamp;
