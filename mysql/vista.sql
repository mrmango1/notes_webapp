# Crear una vista que cuente cuantos tablas tiene la base de datos

CREATE VIEW 
AS numberTables
SELECT count(titles)
FROM
    tables