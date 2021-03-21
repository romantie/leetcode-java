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