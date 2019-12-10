sqlite3 muntatge.db
CREATE TABLE clientes (
		cif CHAR(10) PRIMARY KEY, 
		nombreEmpresa VARCHAR(30) NOT NULL,
		direccion VARCHAR(50) NOT NULL,
		poblacion VARCHAR(50) NOT NULL,
		cp INT(5) UNSIGNED NOT NULL
);

INSERT INTO clientes (cif,nombreEmpresa,direccion,poblacion,cp)
VALUES (A-12345678,'Game Seekers SL','Passeig Pere III','Manresa','08240'),('B-12345678','JORDIMY SL','C. Gran 1','St.vicenç de castellet','08295'),
('C-12345678','SANJUST SL','C. Secretaria canal 10','St.vicenç de castellet','08295'),
('D-12345678','SPORTS SS','C.Barcelona 13','Manresa','08240'),
('E-12345678','Ins Castellet','C. Bisbe perello sn','St.vicenç de castellet','08295')
