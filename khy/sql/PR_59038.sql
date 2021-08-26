select 시간
from (
SELECT datetime as 시간
from animal_ins 
order by datetime asc)
where rownum = 1;