
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

select ifnull(round(count(distinct session_id) / count(distinct user_id),2),0) as k
from activity
where datediff('2019-07-27',activity_date) < 30

select ifnull(
    round(count(distinct session_id) / count(distinct user_id),2),
    0
           )as k
from
    activity
where datediff('2017-07-27',activity) < 30;