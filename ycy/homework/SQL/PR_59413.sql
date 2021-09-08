SELECT TIME.HOUR, NVL(O.COUNT,0) AS COUNT
    FROM 
        (
            SELECT TO_CHAR(DATETIME, 'HH24') AS HOUR, COUNT(*) AS COUNT
            FROM ANIMAL_OUTS
            GROUP BY TO_CHAR(DATETIME, 'HH24')
        ) O
        
        RIGHT OUTER JOIN
        
        (
            SELECT LEVEL-1 AS HOUR 
            FROM DUAL 
            CONNECT BY LEVEL<=24
        ) TIME
        ON O.HOUR = TIME.HOUR
        ORDER BY TIME.HOUR;