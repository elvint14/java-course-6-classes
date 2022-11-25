create table users
(
    id   bigint,
    name varchar(64)
);

select * from users;
insert into users values (null, 'a');
insert into users values (null, 'b', null);
alter table users add column pin varchar(7);
drop table users;


create table users (
                       id          bigint not null unique,
                       pin         varchar(255) not null unique,
                       balance     decimal not null,
                       age         int check (age>=18),
                       create_date date default now()
);

create index users_pin_idx on users (pin);

select * from users where id = 2;
drop table users;

--O(logn)   -> binary search: n=1000 -> log1000=10
--O(n)      -> linear search: n=1000 -> 1000

--O(nlogn)  -> merge sort: n=1000 -> 1000*10=10^4
--O(n^2)    -> buble sort: n=1000 -> 1000*1000=10^6

CREATE TABLE accounts (
                          user_id serial PRIMARY KEY,
                          username VARCHAR ( 50 ) UNIQUE NOT NULL,
                          password VARCHAR ( 50 ) NOT NULL,
                          email VARCHAR ( 255 ) UNIQUE NOT NULL,
                          created_on TIMESTAMP NOT NULL default now(),
                          last_login TIMESTAMP default now()
);

drop table accounts;

select * from accounts;

-- select nextval() from accounts_user_id_seq;

-- select nextval('accounts_user_id_seq');
