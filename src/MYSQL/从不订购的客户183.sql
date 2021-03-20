show databases;
#sql题183，从两表中找出从不订购的客户
#使用子查询，以及not in的查询语句
create table Customers
(
    Id int not null,
    Name varchar(20)
);
create table Orders
(
    Id int not null,
    CustomerId int
);

insert into leetcode.customers values(1,'joe');
insert into leetcode.customers values(2,'henry');
insert into leetcode.customers values(3,'sam');
insert into leetcode.customers values(4,'max');
insert into leetcode.orders values(1,3);
insert into leetcode.orders values(2,1);

select Customers.Name as 'Customers'
from customers
where Customers.Id not in(
    select CustomerId
    from Orders
);