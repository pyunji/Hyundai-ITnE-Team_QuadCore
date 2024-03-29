SELECT A.HOUR, COUNT(B.time)
FROM(
    SELECT LEVEL-1 AS HOUR
    FROM DUAL
    CONNECT BY LEVEL <=24
    ) A LEFT JOIN 
    (
    SELECT animal_id, TO_CHAR(DATETIME, 'HH24') as time
    FROM ANIMAL_OUTS
    ) B ON (A.HOUR = B.time)
GROUP BY A.HOUR
ORDER BY A.HOUR;