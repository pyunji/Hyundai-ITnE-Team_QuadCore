-- 1.
SELECT o.animal_id, o.name
FROM ANIMAL_OUTS o LEFT JOIN ANIMAL_INS i
    ON (o.animal_id = i.animal_id)
WHERE i.animal_id is null
ORDER BY o.animal_id;

/*

animal_id	name
A349480	Daisy
A349733	Allie
A349990	Spice
A362137	*Darcy
*/

-- 2.
SELECT ANIMAL_ID, NAME
FROM (
    SELECT ANIMAL_ID, NAME
    FROM ANIMAL_OUTS
    MINUS
    SELECT ANIMAL_ID, NAME
    FROM ANIMAL_INS
)
ORDER BY ANIMAL_ID;

/*
animal_id	name
A349480	Daisy
A349733	Allie
A349990	Spice
A362137	*Darcy
A395451	Logan
*/

-- 왜 둘의 결과가 다른데 둘 다 정답일까?
/*
SELECT *
FROM ANIMAL_OUTS o LEFT JOIN ANIMAL_INS i
    ON (o.animal_id = i.animal_id)
ORDER BY o.animal_id;
*/

/*
animal_id	animal_type	datetime	name	sex_upon_outcome	animal_id	animal_type	datetime	intake_condition	name	sex_upon_intake
A395451	Dog	2016-01-03 15:54:00	Logan	Neutered Male	A395451	Dog	2015-12-27 17:42:00	Normal	Rogan	Neutered Male

얘때문에
*/