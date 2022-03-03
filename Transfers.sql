create table transfers (
	transferID serial primary key,
	accountSender int not null unique,
	amount dec,
	accountReceiver int not null unique
)

drop table transfers;

select * from transfers;
select transferID, accountSender, amount from transfers where accountReceiver = 1;

insert into transfers values (default, 2, 10000, 1);