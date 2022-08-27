# TRABAJO EN CLASES

# Calcular La importancia de una tarea con su numero del 0-4

DELIMITER $$
CREATE FUNCTION stringImportance(impNumber int)
RETURNS varchar(10)
DETERMINISTIC
BEGIN
IF impNumber=0 then RETURN "No es muy importante";
elseif impNumber=1 then RETURN "No es importante";
elseif impNumber=2 then RETURN "Regular";
elseif impNumber=3 then RETURN "Es importante";
elseif impNumber=4 then RETURN "Urgente";
END IF;
END $$
DELIMITER ;

select stringImportance(importance) from task;


# Calcular el numero de dias hasta la fecha limite

CREATE FUNCTION daysToLimit(startDate date, finalDate date)
RETURNS int(20)
DETERMINISTIC
RETURN TIMESTAMPDIFF(DAY, startDate, finalDate);

select daysToLimit(created_at,limit_date) from task;

# Transformar los codigos de colores a String

DELIMITER $$
CREATE FUNCTION stringColors(color varchar(7))
RETURNS varchar(20)
DETERMINISTIC
BEGIN
IF color='#1a1a1a' then RETURN "Negro";
elseif color='#eff1f5' then RETURN "Blanco";
elseif color='#df8e1d' then RETURN "Amarillo";
elseif color='#209fb5' then RETURN "Azul";
elseif color='#e64553' then RETURN "Rojo";
END IF;
END $$
DELIMITER ;

select stringColors(color) from `table`;