DROP DATABASE BBDDProyectoGym;
CREATE DATABASE BBDDProyectoGym;
USE BBDDProyectoGym;
SELECT * FROM Clientes;
CREATE TABLE Empleados(
idEmpleado INT PRIMARY KEY AUTO_INCREMENT,
NombreE VARCHAR(50),
PuestoTrabajo VARCHAR(50),
Salario DOUBLE,
Telefono VARCHAR(16),
Sector VARCHAR(40),
idMesa INT,
idZona INT,
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
Email Varchar(100),
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

CREATE TABLE ZonaDeporte(
NumTarjeta INT,
idZona INT PRIMARY KEY AUTO_INCREMENT,
Zona VARCHAR(50)
);

CREATE TABLE Suscripcion(
idSubs INT AUTO_INCREMENT PRIMARY KEY,
TipoSubs VARCHAR(40),
PrecioSubs DOUBLE
);
CREATE TABLE ZonaRestauracion(
idMesa INT PRIMARY KEY AUTO_INCREMENT,
MesaNum VARCHAR(30)
);

CREATE TABLE SeSirve(
idMesa INT,
idMenu INT,
FOREIGN KEY(idMesa) REFERENCES ZonaRestauracion(idMesa),
FOREIGN KEY(idMenu) REFERENCES Menu(idMenu)
);

CREATE TABLE Menu(
idMenu INT AUTO_INCREMENT PRIMARY KEY,
ObjetoMenu VARCHAR(50),
Precio DOUBLE
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