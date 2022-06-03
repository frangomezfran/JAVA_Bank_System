drop database Bank_System;

create database Bank_System;

use Bank_System;

create table Banco(
	id_banco INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(25) NOT NULL,
    fecha_inicio DATE NOT NULL,
    PRIMARY KEY(id_banco)
);

create table Sucursal(
	id_sucursal INT NOT NULL AUTO_INCREMENT,
    id_banco INT NOT NULL,
    domicilio VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_sucursal),
    FOREIGN KEY (id_banco) REFERENCES Banco(id_banco)
);

create table Cliente(
	nro_cliente INT NOT NULL AUTO_INCREMENT,
    id_sucursal INT NOT NULL,
    nombre VARCHAR(60) NOT NULL,
    apellido VARCHAR(60) NOT NULL,
    dni BIGINT NOT NULL,
    domicilio VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    cuil BIGINT NOT NULL,
    PRIMARY KEY (nro_cliente),
    FOREIGN KEY (id_sucursal) REFERENCES Sucursal(id_sucursal)
);

create table Empleado(
	nro_empleado INT NOT NULL AUTO_INCREMENT,
    id_sucursal INT NOT NULL,
    nombre VARCHAR(60) NOT NULL,
    apellido VARCHAR(60) NOT NULL,
    dni BIGINT NOT NULL,
    domicilio VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    cuil BIGINT NOT NULL,
    salario DOUBLE NOT NULL,
    area VARCHAR(50) NOT NULL,
    PRIMARY KEY (nro_empleado),
    FOREIGN KEY (id_sucursal) REFERENCES Sucursal(id_sucursal)
);

create table CuentaCorriente(
	nro_cuenta INT NOT NULL AUTO_INCREMENT,
	nro_cliente INT NOT NULL,
	cbu BIGINT NOT NULL,
    clave VARCHAR(20) NOT NULL,
    balance_pesos DOUBLE NOT NULL DEFAULT 0,
	saldo_deudor DOUBLE NOT NULL,
	salario_por_mes DOUBLE NOT NULL,
	PRIMARY KEY (nro_cuenta),
	FOREIGN KEY (nro_cliente) REFERENCES Cliente(nro_cliente)
);

create table CajaDeAhorro(
	nro_cuenta INT NOT NULL AUTO_INCREMENT,
	nro_cliente INT NOT NULL,
	cbu BIGINT NOT NULL,
    clave VARCHAR(20) NOT NULL,
    balance_pesos DOUBLE NOT NULL DEFAULT 0,
	balance_dolares DOUBLE NOT NULL DEFAULT 0,
	PRIMARY KEY (nro_cuenta),
	FOREIGN KEY (nro_cliente) REFERENCES Cliente(nro_cliente)
);

INSERT INTO Banco(id_banco, nombre, fecha_inicio)
VALUES
(1,'Banco Frances','1983-05-25'),
(2,'Banco Provincia','1990-05-25'),
(3,'Banco Patagonia','2000-05-25');

INSERT INTO Sucursal(id_sucursal, id_banco, domicilio)
VALUES
(1,1,'BBVA 123'),
(2,1,'BBVA 456'),
(3,2,'Provincia 123'),
(4,2,'Provincia 456'),
(5,3,'Patagonia 123'),
(6,3,'Patagonia 456'),
(7,3,'Patagonia 789');

INSERT INTO Cliente(nro_cliente,id_sucursal,nombre,apellido,dni,domicilio,telefono,cuil)
VALUES
(1,1,'Franco','Gomez',40111999,'FrancoGomez 123','+549123999',1140111999),
(2,1,'Jone','Torre',40111998,'JoneTorre 123','+549123998',1140111998),

(3,2,'Hajar','Carvajal',40111997,'HajarCarvajal 123','+549123997',1140111997),
(4,2,'Arnau','Benavente',40111996,'ArnauBenavente 123','+549123996',1140111996),

(5,3,'Inmaculada','Souto',40111995,'InmaculadaSouto 123','+549123995',1140111995),
(6,3,'Victoriano','Pellicer',40111994,'VictorianoPellicer 123','+549123994',1140111994),

(7,4,'German','Muriel',40111993,'GermanMuriel 123','+549123993',1140111993),
(8,4,'Santos','Sarmiento',40111992,'SantosSarmiento 123','+549123992',1140111992),

(9,5,'Eider','Freire',40111991,'EiderFreire 123','+549123991',1140111991),
(10,5,'Joaquim','Jorge',40111990,'JoaquimJorge 123','+549123990',1140111990),

(11,6,'Saul','Maya',40111989,'SaulMaya 123','+549123989',1140111989),
(12,6,'Soledad','Prieto',40111988,'SoledadPrieto 123','+549123988',1140111988),

(13,7,'Laureano','Carpio',40111987,'LaureanoCarpio 123','+549123987',1140111987),
(14,7,'Aritz','Salcedo',40111986,'AritzSalcedo 123','+549123986',1140111986),
(15,7,'Rachid','Maldonado',40111985,'RachidMaldonado 123','+549123985',1140111985);

INSERT INTO Empleado(nro_empleado,id_sucursal,nombre,apellido,dni,domicilio,telefono,cuil,salario,area)
VALUES
(1,1,'Rodolfo','Quiles',40111984,'RodolfoQuiles 123','+549123984',1140111984,90000,'Administrativo'),

(2,2,'Beatriz','Santamaria',40111983,'BeatrizSantamaria 123','+549123983',1140111983,90000,'Empleado de Ventanilla'),

(3,3,'Diana','Falcon',40111982,'DianaFalcon 123','+549123982',1140111982,90000,'Cajero de Banco'),

(4,4,'Vicenta','Arteaga',40111981,'VicentaArteaga 123','+549123981',1140111981,90000,'Cajero de Banco'),

(5,5,'Lara','Manzano',40111980,'LaraManzano 123','+549123980',1140111980,90000,'Administrativo'),

(6,6,'Clotilde','Angulo',40111979,'ClotildeAngulo 123','+549123979',1140111979,90000,'Administrativo'),

(7,7,'Roque','Campo',40111978,'RoqueCampo 123','+549123978',1140111978,90000,'Cajero de Banco'),
(8,7,'Alfonsa','Piqueras',40111977,'AlfonsaPiqueras 123','+549123977',1140111977,100000,'Gerente Contabilidad'),
(9,7,'Hector','Luis',40111976,'HectorLuis 123','+549123976',1140111976,90000,'Cajero de Banco');


INSERT INTO CuentaCorriente(nro_cuenta,nro_cliente,cbu,clave,balance_pesos,saldo_deudor,salario_por_mes)
VALUES
(1,1,101,'123',100,0,90000),
(2,2,102,'123',100,0,80000),
(3,3,103,'123',100,0,70000),
(4,4,104,'123',100,0,60000),
(5,5,105,'123',100,0,50000),
(6,6,106,'123',100,0,40000),
(7,7,107,'123',100,0,30000),
(8,8,108,'123',100,0,20000),
(9,9,109,'123',100,0,10000),
(10,10,110,'123',100,0,90000),
(11,11,111,'123',100,0,80000),
(12,12,112,'123',100,0,70000),
(13,13,113,'123',100,0,60000),
(14,14,114,'123',100,0,50000),
(15,15,115,'123',100,0,40000);

INSERT INTO CajaDeAhorro(nro_cuenta,nro_cliente,cbu,clave,balance_pesos,balance_dolares)
VALUES
(1,1,116,'123',100,200),
(2,2,117,'123',100,200);
