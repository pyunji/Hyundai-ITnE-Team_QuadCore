SELECT ANIMAL_ID, NAME, 
    case when (SEX_UPON_INTAKE like 'Intact%') then 'X'
    else 'O'
    end
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;