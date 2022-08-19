delimiter //
CREATE PROCEDURE averagueStudent (averague INT)
       BEGIN
	select
	(case
	 WHEN averague>=0 and averague <= 5 then "Insuficiente"
	 WHEN averague>5 and averague <= 6 then "Aprobado"
	 WHEN averague>7 and averague <= 7 then "Muy Bueno"
	 WHEN averague>7 and averague <= 9 then "Excelente"
	 WHEN averague>9 and averague <= 10 then "Sobresaliente"
	 ElSE ""
       END//
delimiter ;

CREATE VIEW 
view_product AS 
SELECT ProductName, UnitsInStock, ((UnitPrice * 0.12) + UnitPrice) FROM Products


CREATE VIEW 
view_product AS 
SELECT ProductName, UnitsInStock, ((UnitPrice * 0.12) + UnitPrice) FROM Products

CREATE VIEW 
view_product AS 
SELECT ProductName, UnitsInStock, ((UnitPrice * 0.12) + UnitPrice) FROM Products
