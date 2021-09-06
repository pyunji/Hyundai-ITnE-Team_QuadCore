-- 1
select * 
from(
    SELECT i.name, i.datetime
    FROM(
        SELECT animal_id
        FROM ANIMAL_INS
        MINUS
        SELECT animal_id
        FROM ANIMAL_OUTS) ids, animal_ins i
    where ids.animal_id = i.animal_id
    order by i.datetime
)
where rownum <= 3;

--2
select * 
from(
    select i.name, i.datetime
    from animal_ins i left join animal_outs o
    on i.animal_id = o.animal_id
    where o.animal_id is null
    order by i.datetime
    )
where rownum <= 3;

--3
select i.name, i.datetime
from animal_ins i left join animal_outs o
on i.animal_id = o.animal_id
where o.animal_id is null
order by i.datetime fetch first 3 rows only;