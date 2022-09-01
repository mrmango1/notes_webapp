# Crear una vista que cuente cuantos usuarios tiene la base de datos

CREATE VIEW numberUsers
AS 
SELECT count(id)
FROM
    `user`;


# Crear una vista que muestre el nombre de la tabla con mayor cantidad de notas

CREATE VIEW maxNotes
AS
SELECT table_name, count(id)
FROM
    `notes`
GROUP BY
    table_name
ORDER BY
    count(id) DESC;