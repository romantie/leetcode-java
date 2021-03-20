
#sql题183，从两表中找出从不订购的客户
#使用子查询，以及not in的查询语句

# 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
#
# Customers 表：
#
# +----+-------+
# | Id | Name  |
# +----+-------+
# | 1  | Joe   |
# | 2  | Henry |
# | 3  | Sam   |
# | 4  | Max   |
# +----+-------+
# Orders 表：
#
# +----+------------+
# | Id | CustomerId |
# +----+------------+
# | 1  | 3          |
# | 2  | 1          |
# +----+------------+
# 例如给定上述表格，你的查询应返回：
#
# +-----------+
# | Customers |
# +-----------+
# | Henry     |
# | Max       |
# +-----------+
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