create table login
(
	loginID serial primary key,
	username varchar(20) not null unique,
	password varchar(20) not null,
	isEmployee boolean not null default false
) 

drop table login;

select * from login;

insert into login values(default, 'alex', 'root', true);