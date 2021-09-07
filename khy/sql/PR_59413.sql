SELECT B.HOUR, NVL(A.CNT,0) AS COUNT FROM 
(
    SELECT TO_CHAR(DATETIME,'HH24') AS HOUR, COUNT(*) AS CNT 
    FROM ANIMAL_OUTS
    GROUP BY TO_CHAR(DATETIME,'HH24')
) A
RIGHT OUTER JOIN
(
    SELECT LEVEL-1 AS HOUR 
    FROM DUAL 
    CONNECT BY LEVEL<=24
) B
ON A.HOUR=B.HOUR
ORDER BY B.HOUR