create table customers
(
    customer_id   bigint,
    customer_name varchar(255),
    contact_name  varchar(255),
    address      varchar(255),
    city         varchar(255),
    postal_code   varchar(255),
    country      varchar(255)
);

alter table customers
    owner to postgres;

INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (1, 'Alfreds Futterkiste ', 'Maria Anders ', 'Obere Str. 57 ', 'Berlin ', '12209 ', 'Germany ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (2, 'Ana Trujillo Emparedados y helados ', 'Ana Trujillo ', 'Avda. de la Constitución 2222 ', 'México D.F. ', '05021 ', 'Mexico ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (3, 'Antonio Moreno Taquería ', 'Antonio Moreno ', 'Mataderos 2312 ', 'México D.F. ', '05023 ', 'Mexico ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (4, 'Around the Horn ', 'Thomas Hardy ', '120 Hanover Sq. ', 'London ', 'WA1 1DP ', 'UK ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (5, 'Berglunds snabbköp ', 'Christina Berglund ', 'Berguvsvägen 8 ', 'Luleå ', 'S-958 22 ', 'Sweden ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (6, 'Blauer See Delikatessen ', 'Hanna Moos ', 'Forsterstr. 57 ', 'Mannheim ', '68306 ', 'Germany ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (7, 'Blondel père et fils ', 'Frédérique Citeaux ', '24, place Kléber ', 'Strasbourg ', '67000 ', 'France ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (8, 'Bólido Comidas preparadas ', 'Martín Sommer ', 'C/ Araquil, 67 ', 'Madrid ', '28023 ', 'Spain ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (9, 'Bon app'' ', 'Laurence Lebihans ', '12, rue des Bouchers ', 'Marseille ', '13008 ', 'France ');
INSERT INTO customers (customerid, customername, contactname, address, city, postalcode, country) VALUES (10, 'Bottom-Dollar Marketse ', 'Elizabeth Lincoln ', '23 Tsawassen Blvd. ', 'Tsawassen ', 'T2F 8M4 ', 'Canada ');
