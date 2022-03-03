create table employees (
	accountNumber int not null unique,
	username varchar(20) not null unique,
	password varchar(20) not null,
)

drop table employees;

select * from customers;

insert into customers values (default, 'Alex', 'root');