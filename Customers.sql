create table customers (
	accountNumber int not null unique,
	username varchar(20) not null unique,
	password varchar(20) not null,
	balance dec not null check(balance >= 0) default 10000.00
)

drop table customers;

select * from customers;

insert into customers values (1, 'Bagel', 'root', default);

update customers set balance = balance - 99 where accountNumber = 1;




create or replace procedure transferAmountAndGetbalance
(
   sender int,
   reciever int,
   amount dec,
  INOUT debitorBalance int,
  INOUT creditorBalance int
)
language  plpgsql
as $$
begin 
		update accounts set balance = balance - amount where id = sender;
		update accounts set balance = balance + amount where id = receiver;
		select balance into debitorBalance from accounts where id = sender;
		select balance into creditorBalance from accounts where id = reciever;
commit;
end;$$