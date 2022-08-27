delimiter //

# Crear un trigger que permita controlar la fecha limite de actividades ya que esta debe ser mayor que la fecha de creacion.

DELIMITER $$
CREATE TRIGGER dateLimitBeforeCreate 
BEFORE INSERT ON task for each row
BEGIN
    IF old.createad_at > new.limit_date then set new.limit_date = old.createad_at;
    END IF;
END $$
DELIMITER ;