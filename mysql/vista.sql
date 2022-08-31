# Crear una vista que cuente cuantos tablas tiene la base de datos

CREATE VIEW numberTables
AS 
SELECT count(titles)
FROM
    `table`;

# Crear una vista que cuente cuantos usuarios tiene la base de datos

CREATE VIEW numberUsers
AS 
SELECT count(id)
FROM
    `user`;

