create table Employee
(
    Id int not null,
    Name varchar(20),
    Salary int ,
    DepartmentId int,
    primary key (id)
);
create table Department
(
    Id int not null,
    Name varchar(20)
);
insert into employee value(1,'joe',70000,1);
insert into employee value(2,'jim',90000,1);
insert into employee value(3,'hery',80000,2);
insert into employee value(4,'sam',60000,2);
insert into employee value(5,'max',90000,1);

insert into department (Id, Name)
values (1,'IT');
insert into department values(2,'Sales');

select  Department.Name department,Employee.Name Employee,Employee.Salary
from employee,department
where
        Employee.DepartmentId = Department.Id
  and (Employee.DepartmentId,Salary)
    in (select DepartmentId,max(Salary)
        from employee
        group by DepartmentId
      );

select DepartmentId,max(Salary)
from Employee
group by DepartmentId;
#求topn的问题
select DepartmentId,Name,Salary
from (
         select
             dense_rank() over (partition by DepartmentId order by Salary) as rannking,DepartmentId,Name,Salary
         from employee
     ) as a
where rannking <= 3;
select
    B.Name AS Department,
    A.Name AS Employee,
    A.Salary
from (
         select dense_rank() over (partition by DepartmentId order by Salary desc) as ranking,DepartmentId,Name,Salary
         from employee
     ) as a
         join Department as b on b.Id = a.DepartmentId
where a.ranking <= 3;
SELECT NOW(),CURDATE(),CURTIME();
SELECT DAY(NOW())


#time:2021 3 21
create table Activity
(
    play_id int not null,
    device_id int not null,
    event_date date not null,
    games_played int not null
);

insert into activity values(1,2,'2016-05-01',5);
insert into activity values(1,2,'2016-03-02',6);
insert into activity values(2,3,'017-06-25',1);
insert into activity values(3,1,'2016-03-02',0);
insert into activity values(3,4,'2018-07-03',0);
insert into activity values(4,4,'2018-07-03',0);
insert into activity values(4,4,'2018-05-03',0);



select play_id,min(event_date) as frist_login
from activity
group by play_id;
select *
from activity;
## 游戏分析
select play_id,device_id
from activity
where (play_id,event_date) in (
    select play_id,min(event_date) as frist_login
    from activity
    group by play_id
);

select play_id,device_id
from(
        select play_id,device_id,rank() over (partition by play_id order by event_date) as 'rank'
        from activity
    ) as a
where 'rank' = 1;

##使用自联结，先找出日期大的那一天然后相加
select *
from activity;

select *,sum(games_played)
from activity a ,activity b
where a.play_id=b.play_id and a.event_date > b.event_date;

select a.play_id,a.event_date,sum(b.games_played) as k
from activity a,activity b
where a.play_id = b.play_id and a.event_date >= b.event_date
group by a.play_id, a.event_date;

select *
from activity a,activity b
where a.play_id = b.play_id and a.event_date >= b.event_date
group by a.play_id, a.event_date;

#求中位数
SELECT id, company, salary
FROM
    (
        SELECT id, company, salary,
               ROW_NUMBER() OVER (PARTITION BY company ORDER BY Salary ASC, id ASC) AS row_num,
               COUNT(Id) OVER (PARTITION BY company) AS count_id
        FROM Employee
    )
WHERE row_num IN (FLOOR((count_id + 1)/2), FLOOR((count_id + 2)/2))


create table Activity
(
    play_id int not null,
    device_id int not null,
    event_date date not null,
    games_played int not null
);

insert into activity values(1,2,'2016-05-01',5);
insert into activity values(1,2,'2016-03-02',6);
insert into activity values(2,3,'017-06-25',1);
insert into activity values(3,1,'2016-03-02',2);
insert into activity values(3,4,'2018-07-03',7);
insert into activity values(4,4,'2018-07-03',3);
insert into activity values(4,4,'2018-05-03',4);


select a.play_id,a.device_id
from (
         select play_id,min(event_date) as frist_login,device_id
         from activity
         group by play_id
     ) as a;

select play_id,device_id
from activity
where (play_id,event_date) in (
    select play_id,min(event_date) as frist_login
    from activity
    group by play_id
);

select play_id,device_id
from(
        select play_id,device_id,rank() over (partition by play_id order by event_date) as 'rank'
        from activity
    ) as a
where 'rank' = 1;

select *
from activity;

select *,sum(games_played)
from activity a ,activity b
where a.play_id=b.play_id and a.event_date > b.event_date

select a.play_id,a.event_date,sum(b.games_played) as k
from activity a,activity b
where a.play_id = b.play_id and a.event_date >= b.event_date
group by a.play_id, a.event_date;

select *
from activity a,activity b
where a.play_id = b.play_id and a.event_date >= b.event_date
group by a.play_id, a.event_date;

SELECT NOW();
SELECT year(DATE_FORMAT(NOW(),'%Y-%m-%d')) year

select *
from cinema a join cinema b
                   on abs(a.seat_id - b.seat_id) = 1
                       and a.free = true and b.free = true;


select seat_id
from cinema a join cinema b
                   on abs(a.seat_id - b.seat_id) = 1
                       and a.free = true and b.free = true
group by a.seat_id;

Create table If Not Exists Books (book_id int, name varchar(50), available_from date);
Create table If Not Exists Orders (order_id int, book_id int, quantity int, dispatch_date date);
Truncate table Books;
insert into Books (book_id, name, available_from) values ('1', 'Kalila And Demna', '2010-01-01');
insert into Books (book_id, name, available_from) values ('2', '28 Letters', '2012-05-12');
insert into Books (book_id, name, available_from) values ('3', 'The Hobbit', '2019-06-10');
insert into Books (book_id, name, available_from) values ('4', '13 Reasons Why', '2019-06-01');
insert into Books (book_id, name, available_from) values ('5', 'The Hunger Games', '2008-09-21');
Truncate table Orders;
insert into Orders values ('1', '1', '2', '2018-07-26');
insert into Orders values ('2', '1', '1', '2018-11-05');
insert into Orders values ('3', '3', '8', '2019-06-11');
insert into Orders values ('4', '4', '6', '2019-06-05');
insert into Orders values ('5', '4', '5', '2019-06-20');
insert into Orders values ('6', '5', '9', '2009-02-02');
insert into Orders values ('7', '5', '8', '2010-04-13');

select b.book_id,b.name
from Orders o join Books b
                   on o.book_id = b.book_id
where o.quantity < 10 and datediff('2019-06-23',b.available_from);

select b.book_id, name
from books b left join orders o
                       on b.book_id = o.book_id and dispatch_date >= '2018-06-23'
where available_from < '2019-05-23'
group by b.book_id
having ifnull(sum(quantity), 0) < 10