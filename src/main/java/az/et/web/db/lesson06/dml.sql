
------------ DML ------------
TRUNCATE TABLE people;

SELECT * FROM people; -- *,% => all, ?_ => one symbol

CREATE TABLE customers
(
    CustomerID   bigint,
    CustomerName varchar(255),
    ContactName  varchar(255),
    Address      varchar(255),
    City         varchar(255),
    PostalCode   varchar(255),
    Country      varchar(255)
);

select count(City) from customers;
select count(distinct(City)) from customers;
select * from customers;
select * from customers where City = 'Berlin ';
select * from customers where City like '_o%';
select * from customers where CustomerID > 3 and CustomerID < 7;
select * from customers order by City desc, CustomerName asc;

insert into customers
values (16, 'Elvin3', 'Elvin3', null, 'Baku', 'AZ1000', 'AZE');

select * from customers where Address is not null;
