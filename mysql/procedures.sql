
# Crear una vista que permita ver las tablas creadas por cada usuario

# 1
# tareas del hogas
# tareas del trabajo
# compras a realizar

# 2
# tareas de la u
# tasad sd 

DELIMITER &&  
CREATE PROCEDURE userTables (int id)
BEGIN    
  select * from table where id_user=id
END &&  
DELIMITER ;   

call userTables(id)

