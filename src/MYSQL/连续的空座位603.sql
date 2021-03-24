
#连续的空座位，采取表自联结，然后找出id大的一个，找出free=true
#然后分组排序


select a.seat_id
from cinema a join cinema b
    on abs(a.seat_id - b.seat_id) = 1
    and a.free = true and b.free = true
group by a.seat_id
order by a.seat_id;

##查询近30天的活跃用户数
select activity_data as day ,count(distinct user_id) as activity_users
from Activity
where datediff('2019-07-27',activity_date) < 30
group by activity_data;

##查询过去30天的的登陆数平均
select ifnull(round(count(distinct session_id) / count(distinct user_id),2),0) as k
from activity
where datediff('2019-07-27',activity_date) < 30;

select ifnull(
    round(count(distinct session_id) / count(distinct user_id),2),
    0
           )as k
from
    activity
where datediff('2017-07-27',activity) < 30;

##580统计各专业学生人数，先将两表进行连接，使用count(Student_id)来计算数目
SELECT
    dept_name, COUNT(student_id) AS student_number
FROM
    department
        LEFT OUTER JOIN
    student ON department.dept_id = student.dept_id
GROUP BY department.dept_name
ORDER BY student_number DESC , department.dept_name
;

## 变更性别,要想动态地将值设置成列，我们可以在使用 CASE...WHEN... 流程控制语句的同时使用 UPDATE 语句。

update salary
set
    sex =
        case sex
            when "m" then 'f'
            else 'm'
        end ;
##596超过5名学生的课，使用group by将课程分组，结合having查出超过5名学生的课
select class
from courses
group by class
having count(distinct student) >= 5