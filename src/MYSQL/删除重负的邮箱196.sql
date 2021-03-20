# 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
#
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
# Id 是这个表的主键。
# 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
#
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# +----+------------------+

create table Person
(
    Id int not null,
    Email varchar(40) not null,
    primary key (Id)
);

insert into Person value (1,'25531546@qq.com');
insert into Person value (2,'25531546@qq.com');
insert into Person value (3,'955346@qq.com');
insert into Person value (4,'955346@qq.com');
insert into Person value (5,'sdfsf46@qq.com');

select Id,Email
from Person
group by Person.Email

delete p1.*
from Person p1,person p2
where p1.Email = p2.Email AND p1.Id > P2.Id