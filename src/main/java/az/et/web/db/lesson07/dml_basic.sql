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

select * from customers;

insert into customers (CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
values (92,'Wolski' ,'Zbyszek' ,'ul. Filtrowa 68' ,'Walla' ,'01-012' ,'Poland' );

-- crud
-- ddl -> create,    dml -> insert
-- ddl -> select,    dml -> select
-- ddl -> alter,     dml -> update
-- ddl -> drop,      dml -> delete

select * from customers
              -- where silinmeli like 'odd%'
order by CustomerID;
delete   from customers where customerid = 92;

alter table customers ADD column silinmeli varchar(10);
-- update customers set silinmeli = 'added';
update customers set silinmeli = 'even_row' where mod(customerid, 2) = 0;
update customers set silinmeli = 'odd_row' where mod(customerid, 2) <> 0;
alter table customers drop silinmeli;

select * from customers order by City desc limit 10;

select max(length(customername)) from customers;
select max(length(customername)), CustomerName from customers group by CustomerName;

select sum(customerid) from customers;

select * from customers where City in ('Berlin ', 'Warsaw ', 'Torino ');
select * from customers where CustomerID between 30 and 90; -- CustomerID >= 3 and CustomerID <= 9

select c.CustomerID, c.CustomerName, c.ContactName  from customers as c;
