SELECT HOUR, COUNT(*) AS COUNT
FROM (SELECT TO_CHAR(DATETIME, 'HH24') AS HOUR
FROM ANIMAL_OUTS)
GROUP BY HOUR
HAVING HOUR >= 9 AND HOUR < 20
ORDER BY HOUR;