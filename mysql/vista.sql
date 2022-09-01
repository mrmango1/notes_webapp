# Crear una vista que cuente cuantos usuarios tiene la base de datos

CREATE VIEW numberUsers
AS 
SELECT count(id_user)
FROM
    `user`;


# Crear una vista que muestre el nombre del usuario con mayor contidad de notas

CREATE VIEW userWithMoreNotes
AS
SELECT firstname, lastname, count(id_task)
FROM
    `user`
    JOIN `table` ON `user`.id_user = `table`.id_user
    JOIN `task` ON `task`.id_table = `task`.id_table
GROUP BY `user`.id_user
ORDER BY count(id_task) DESC limit 5;

# Crear una vista que muestre los asuntos mas utilizados por los usuarios

CREATE VIEW maxAsuntos
AS
SELECT asunto, count(id)
FROM
    `notes`
GROUP BY
    asunto
ORDER BY
    count(id) DESC;