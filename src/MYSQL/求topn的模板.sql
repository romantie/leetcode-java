
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


#温度上升
select Weather.id as Id
from Weather
         join
     Weather b ON datediff(Weather.recordDate,b.recordDate) = 1
         AND Weather.Temperature > b.Temperature