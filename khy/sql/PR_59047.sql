SELECT animal_id, name 
FROM ANIMAL_INS
WHERE LOWER(NAME) LIKE '%el%' and animal_type = 'Dog'
order by name;