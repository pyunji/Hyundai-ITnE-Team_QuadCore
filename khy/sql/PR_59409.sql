SELECT 
animal_id, 
name, 
case when sex_upon_intake like '%Neutered%' then 'O'
     when sex_upon_intake like '%Spayed%' then 'O'
                     else 'X' END AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;