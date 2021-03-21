
#连续的空座位，采取表自联结，然后找出id大的一个，找出free=true
#然后分组排序


select a.seat_id
from cinema a join cinema b
    on abs(a.seat_id - b.seat_id) = 1
    and a.free = true and b.free = true
group by a.seat_id
order by a.seat_id;