SELECT O.ANIMAL_ID, O.NAME from ANIMAL_INS i
RIGHT OUTER JOIN ANIMAL_OUTS o 
on i.animal_id = o.animal_id
WHERE INTAKE_CONDITION IS NULL
ORDER BY O.ANIMAL_ID, O.NAME;