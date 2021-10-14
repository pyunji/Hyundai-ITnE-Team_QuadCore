SELECT O.ANIMAL_ID, O.NAME 
FROM ANIMAL_INS I RIGHT JOIN ANIMAL_OUTS O 
ON I.ANIMAL_ID = O.ANIMAL_ID 
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME