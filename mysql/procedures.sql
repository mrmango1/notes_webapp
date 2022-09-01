# Crear un procedimiento que permita ver las tablas creadas por cada usuario
DELIMITER &&  
CREATE PROCEDURE userTables (id int)
BEGIN    
  select * from `table` where id_user=id;
END &&  
DELIMITER ;   

call userTables(id)

# Crear un procedimiento que verifique si un correo ya existe en la base de datos
DELIMITER &&
CREATE PROCEDURE Register (userFirstName varchar(40) ,userLastName varchar(45) ,userEmailvarchar varchar(45),userPwd varchar(45))
BEGIN
  INSERT INTO users (firstname,lastname,email,password)
  VALUES (userFirstName,userLastName,userEmail,md5(userPwd))
  WHERE NOT EXISTS (SELECT email FROM users WHERE email=userEmail);
END &&
DELIMITER ;

