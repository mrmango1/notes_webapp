# TRABAJO EN CLASES
use `to-do`;
# Calcular La importancia de una tarea con su numero del 0-4
DELIMITER $$
CREATE FUNCTION stringImportance(impNumber int)
RETURNS varchar(10)
DETERMINISTIC
BEGIN
CASE
    WHEN impNumber=0 then RETURN "No es muy importante";
	WHEN impNumber=1 then RETURN "No es importante";
	WHEN impNumber=2 then RETURN "Regular";
	WHEN impNumber=3 then RETURN "Es importante"; 
	WHEN impNumber=4 then RETURN "Urgente";
END CASE;
END $$
DELIMITER ;

select stringImportance(importance) from task;


# Calcular el numero de dias hasta la fecha limite

CREATE FUNCTION daysToLimit(finalDate date)
RETURNS int(6)
DETERMINISTIC
RETURN TIMESTAMPDIFF(DAY, curdate(), finalDate);

select daysToLimit(created_at,limit_date) from task;

# Transformar los codigos de colores a String

DELIMITER $$
CREATE FUNCTION stringColors(color varchar(7))
RETURNS varchar(20)
DETERMINISTIC
BEGIN
CASE
    WHEN color='#179299' then RETURN "light";
	WHEN color='#31748f' then RETURN "primary";
	WHEN color='#fe640b' then RETURN "warning";
	WHEN color='#e64553' then RETURN "danger";
	WHEN color='#7287fd' then RETURN "secondary";
	WHEN color='#dc8a78' then RETURN "info";
	WHEN color='#8839ef' then RETURN "success";
	WHEN color='#4c4f69' then RETURN "dark";
END CASE;
END $$
DELIMITER ;

select stringColors(color) from `table`;