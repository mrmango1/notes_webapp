
# Crear un procedimiento que permita ver las tablas creadas por cada usuario

DELIMITER &&  
CREATE PROCEDURE userTables (int id)
BEGIN    
  select * from table where id_user=id
END &&  
DELIMITER ;   

call userTables(id)

# Crear un procedimiento que verifique si un correo ya existe en la base de datos

DELIMITER &&
CREATE PROCEDURE emailExists (varchar(50) mail)
BEGIN
  select * from user where email=mail then return "true"
  else return "false"
END &&
DELIMITER ;
