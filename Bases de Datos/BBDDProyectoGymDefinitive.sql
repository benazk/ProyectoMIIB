DROP DATABASE BBDDProyectoGym1;
CREATE DATABASE BBDDProyectoGym1;
USE BBDDProyectoGym1;
SELECT * FROM Deportistas;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM ZonaRestauracion;
UPDATE ZonaRestauracion SET MesaNum = "40A" WHERE idMesa = 40;

CREATE TABLE Suscripcion(
idSubs INT AUTO_INCREMENT PRIMARY KEY,
TipoSubs VARCHAR(40),
PrecioSubs DOUBLE
);
CREATE TABLE ZonaDeporte(
NumTarjeta INT,
idZona INT PRIMARY KEY AUTO_INCREMENT,
Zona VARCHAR(50)
);
CREATE TABLE ZonaRestauracion(
idMesa INT PRIMARY KEY AUTO_INCREMENT,
MesaNum VARCHAR(30)
);
CREATE TABLE Menu(
idMenu INT AUTO_INCREMENT PRIMARY KEY,
ObjetoMenu VARCHAR(50),
Precio DOUBLE
);
CREATE TABLE Empleados(
idEmpleado INT PRIMARY KEY AUTO_INCREMENT,
NombreE VARCHAR(50),
PuestoTrabajo VARCHAR(50),
Salario DOUBLE,
Telefono VARCHAR(16),
Sector VARCHAR(40),
idMesa INT, (hay 40) 
idZona INT, (hay 20)
FOREIGN KEY(idMesa) REFERENCES ZonaRestauracion(idMesa),
FOREIGN KEY(idZona) REFERENCES ZonaDeporte(idZona)
);

CREATE TABLE Deportistas(
idDeportista INT PRIMARY KEY AUTO_INCREMENT,
NombreD VARCHAR(50),
ApellidoD VARCHAR(50),
Email Varchar(100),
Telefono VARCHAR(16),
FechaInicio TIMESTAMP,
idSubs INT,
FOREIGN KEY(idSubs) REFERENCES Suscripcion(idSubs)
);
CREATE TABLE Comensales(
idComensal INT PRIMARY KEY AUTO_INCREMENT,
NombreC VARCHAR(50),
ApellidoC VARCHAR(50),
Email VARCHAR(100),
Telefono VARCHAR(16),
DiaYHora TIMESTAMP,
idMesa INT,
idMenu INT,
FOREIGN KEY(idMenu) REFERENCES Menu(idMenu),
FOREIGN KEY(idMesa) REFERENCES ZonaRestauracion(idMesa)
);
CREATE TABLE Entrenan(
idZona INT,
idDeportista INT,
FOREIGN KEY(idZona) REFERENCES ZonaDeporte(idZona),
FOREIGN KEY(idDeportista) REFERENCES Deportistas(idDeportista)
);

CREATE TABLE SeSirve(
idMesa INT,
idMenu INT,
FOREIGN KEY(idMesa) REFERENCES ZonaRestauracion(idMesa),
FOREIGN KEY(idMenu) REFERENCES Menu(idMenu)
);


INSERT INTO Menu (objetomenu, precio) VALUES ("pescado + postre", 24),
("marisco + postre", 29.50),
("carne + postre", 27.75),
("pollo + postre", 22.20),
("sopa + postre", 18.99),
("ensalada + postre", 15.60),
("legumbres + postre", 19.00),
("menu vegano", 22.00),
("menu proteinico", 20.00)
;
INSERT INTO Suscripcion (TipoSubs, PrecioSubs) VALUES ("Una Sesion", 20.0 ),
("Dos Sesiones", 35.00 ),
("Semanal", 60.00 ),
("Mensual", 120.00 ),
("Dos Meses", 220.00 ),
("Seis Meses", 600.00 ),
("Anual", 1000.00); 

INSERT INTO ZonaDeporte (NumTarjeta, Zona) VALUES 
(152364, 'Zona 1'),
(256987, 'Zona 2'),
(235657, 'Zona 3'),
(897414, 'Zona 4'),
(932541, 'Zona 5'),
(852339, 'Zona 6'),
(874535, 'Zona 7'),
(489126, 'Zona 8'),
(874235, 'Zona 9'),
(459621, 'Zona 10');