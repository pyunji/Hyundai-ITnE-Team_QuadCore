select name from
(SELECT name from animal_ins order by datetime)
where rownum = 1;