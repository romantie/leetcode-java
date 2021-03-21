#找出重复的邮件，先使用group by分组，之后使用having语句找出数量大于一的
show tables;
insert into Person
values (4,'asddfgf@qq.com');
insert into person
values (6,'asddfgf@qq.com');
select *
from person;

select Email
from person
group by Email
having count(Email) > 1