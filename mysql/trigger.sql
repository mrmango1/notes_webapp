# Crear un trigger que transforme el nombre del color en codigo hexadecimal al insertar una nueva actividad.
DELIMITER $$
CREATE TRIGGER colorStringToHexInsert 
BEFORE INSERT ON `table` for each row
BEGIN
CASE
    WHEN NEW.color = "teal" THEN SET NEW.color = "#179299";
    WHEN NEW.color = "pine" THEN SET NEW.color = "#31748f";
    WHEN NEW.color = "peach" THEN SET NEW.color = "#fe640b";
    WHEN NEW.color = "marron" THEN SET NEW.color = "#e64553";
    WHEN NEW.color = "lavender" THEN SET NEW.color = "#7287fd";
    WHEN NEW.color = "rosewater" THEN SET NEW.color = "#dc8a78";
    WHEN NEW.color = "mauve" THEN SET NEW.color = "#8839ef";
    WHEN NEW.color = "dark" THEN SET NEW.color = "#4c4f69";
END CASE;
END $$
DELIMITER ;

# Crear un trigger que transforme el nombre del color en codigo hexadecimal al actualizar una actividad.
DELIMITER $$
CREATE TRIGGER colorStringToHexUpdate 
BEFORE UPDATE ON `table` for each row
BEGIN
CASE
    WHEN NEW.color = "teal" THEN SET NEW.color = "#179299";
    WHEN NEW.color = "pine" THEN SET NEW.color = "#31748f";
    WHEN NEW.color = "peach" THEN SET NEW.color = "#fe640b";
    WHEN NEW.color = "marron" THEN SET NEW.color = "#e64553";
    WHEN NEW.color = "lavender" THEN SET NEW.color = "#7287fd";
    WHEN NEW.color = "rosewater" THEN SET NEW.color = "#dc8a78";
    WHEN NEW.color = "mauve" THEN SET NEW.color = "#8839ef";
    WHEN NEW.color = "dark" THEN SET NEW.color = "#4c4f69";
END CASE;
END $$
DELIMITER ;

# Crear un trigger que transforme el nombre de la importancia de una tarea en una escala del 0 al 4 al insertar una nueva actividad.
DELIMITER $$
CREATE TRIGGER priorityStringToIntInsert
BEFORE INSERT ON `task` for each row
BEGIN
CASE
    WHEN NEW.importance = "Tomate tu tiempo" THEN SET NEW.importance = 0;
    WHEN NEW.importance = "No es importante" THEN SET NEW.importance = 1;
    WHEN NEW.importance = "Regular" THEN SET NEW.importance = 2;
    WHEN NEW.importance = "Importante" THEN SET NEW.importance = 3;
    WHEN NEW.importance = "Urgente" THEN SET NEW.importance = 4;
END CASE;
END $$