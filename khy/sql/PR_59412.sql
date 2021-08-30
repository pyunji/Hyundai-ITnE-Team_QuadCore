SELECT hour(dateTime) as 'HOUR', count(*) as 'COUNT'
from animal_outs
group by HOUR
having HOUR >=9 and HOUR<=19
order by HOUR;