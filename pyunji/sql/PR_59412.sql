-- 1.
SELECT hour, COUNT(hour)
FROM (
    SELECT EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) AS hour
    FROM ANIMAL_OUTS
)
WHERE hour >= 9 AND hour < 20
GROUP BY hour
ORDER BY hour;

-- 2.
SELECT hour, COUNT(hour)
FROM (
    SELECT TO_CHAR(DATETIME, 'HH24') AS hour
    FROM ANIMAL_OUTS
)
WHERE hour >= 9 AND hour < 20
GROUP BY hour
ORDER BY hour;