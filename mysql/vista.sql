# Crear una vista que cuente cuantos usuarios tiene la base de datos

CREATE VIEW numberUsers
AS 
SELECT count(id_user)
FROM
    `user`;

# Crear una vista que muestre cuantas notas tiene cada tabla

CREATE VIEW numberNotes
AS
SELECT Tbl.id_table, count(T.id_task)
FROM
    `table` Tbl
JOIN task T
ON Tbl.id_table=T.id_table
GROUP BY Tbl.id_table;

# Crear una vista que muestre los 5 usuarios con mas notas

CREATE VIEW userWithMoreNotes
AS
SELECT concat(U.firstname," ",U.lastname) as "Name", count(T.id_task) as "Task Number"
FROM
    `table` Tbl
JOIN task T
ON Tbl.id_table=T.id_table
JOIN user U
on U.id_user=Tbl.id_user
GROUP BY Tbl.id_user limit 5;