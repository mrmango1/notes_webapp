# Crear un procedimiento que permita ver las tablas creadas por cada usuario
DELIMITER &&  
CREATE PROCEDURE userTables (id int)
BEGIN    
  select id_table, title, description, stringColors(color) from `table` where id_user=id;
END &&  
DELIMITER ;   

call userTables(id)

# Crear un procedimiento que verifique si un correo ya existe en la base de datos
DELIMITER &&
CREATE PROCEDURE Register (userFirstName varchar(40) ,userLastName varchar(45) ,userEmail varchar(45),userPwd varchar(45))
BEGIN
  INSERT INTO user (firstname,lastname,email,password)
  SELECT userFirstName,userLastName,userEmail,md5(userPwd)
  FROM dual
  WHERE NOT EXISTS (SELECT email FROM user WHERE email=userEmail);
END &&
DELIMITER ;

# Crear un procedimiento que permita ver el id,descripcion,importancia,fecha limite, si se realizo, y el nombre del asunto de la nota
# de una tabla determinada

DELIMITER &&
CREATE PROCEDURE notesDetail (id int)
BEGIN
select T.id_task, T.title, T.description, stringImportance(T.importance), T.limit_date, T.done, TP.name
from task T
left join topic_has_task ThT
on T.id_task = ThT.id_task
left join topic TP
on ThT.id_topic = TP.id_topic
where T.id_table=id;
END &&
DELIMITER ;
