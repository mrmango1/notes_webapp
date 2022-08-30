
# Crear una vista que permita ver las tablas creadas por cada usuario

DELIMITER &&  
CREATE PROCEDURE userTables (int id)
BEGIN    
  select * from table where id_user=id
END &&  
DELIMITER ;   

call userTables(id)

