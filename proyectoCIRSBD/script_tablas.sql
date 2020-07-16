CREATE DATABASE dbSistemaCirs;

USE dbSistemaCirs;

CREATE TABLE tiposUsuarios(
	idTipo INT AUTO_INCREMENT NOT NULL ,
    descripcion VARCHAR(100) NULL,
    PRIMARY KEY(idTipo)
);
CREATE TABLE usuariosSistema (
  ciUsuario VARCHAR(10) NOT NULL,
  idTipo INT NULL,
  `password` VARCHAR(45) NULL,
  nombres VARCHAR(45) NULL,
  apellidos VARCHAR(45) NULL,
  correo VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  fechaNa DATE NULL,
  PRIMARY KEY (ciUsuario),
  FOREIGN KEY(idTipo) REFERENCES tiposUsuarios (idTipo)
  );

CREATE TABLE opcionesSistema(
	idOpcion INT AUTO_INCREMENT NOT NULL ,
    descripcion VARCHAR(100) NULL, 
    PRIMARY KEY(idOpcion) 
);

CREATE TABLE tiposUsuariosOpciones(
	idTipo INT NULL,
    idOpcion INT NULL,
    FOREIGN KEY(idTipo) REFERENCES tiposUsuarios (idTipo),
    FOREIGN KEY(idOpcion) REFERENCES opcionesSistema (idOpcion)
);

CREATE TABLE aportesMensuales(
	idAporte INT AUTO_INCREMENT NOT NULL ,
    fechaAporte DATE NULL,
	valor FLOAT NULL,
    PRIMARY KEY(idAporte)
);

CREATE TABLE usuariosAportes(
	ciUsuario VARCHAR(10) NULL,
    idAporte INT NULL,
	FOREIGN KEY(ciUsuario) REFERENCES usuariosSistema (ciUsuario),
    FOREIGN KEY(idAporte) REFERENCES aportesMensuales (idAporte)
);

CREATE TABLE solicitudes(
	idSolicitud INT AUTO_INCREMENT NOT NULL,
    fechaSolicitud DATE NULL,
    descripcion VARCHAR(100),
    estadoSolicitud VARCHAR(15),
    PRIMARY KEY (idSolicitud)
);

CREATE TABLE usuariosSolicitudes(
	ciUsuario VARCHAR(10) NULL,
    idSolicitud INT NULL,
	FOREIGN KEY(ciUsuario) REFERENCES usuariosSistema (ciUsuario),
    FOREIGN KEY(idSolicitud) REFERENCES solicitudes (idSolicitud)
);

CREATE TABLE tiposGastos(
	idTipo INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(100),
    PRIMARY KEY(idTipo)
);

CREATE TABLE gastos(
	idGasto INT NOT NULL,
    idTipo INT NULL,
    fechaSolicitud DATE NULL,
    descripcion VARCHAR(100) NULL,
    valor FLOAT NULL,
    PRIMARY KEY (idGasto),
	FOREIGN KEY(idTipo) REFERENCES tiposGastos (idTipo)
);

CREATE TABLE usuariosGastos(
	ciUsuario VARCHAR (10) NULL,
    idGasto INT,
    FOREIGN KEY(ciUsuario) REFERENCES usuariosSistema (ciUsuario),
    FOREIGN KEY(idGasto) REFERENCES gastos (idGasto)
);

CREATE TABLE tiposCreditos(
	idTipo INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(100),
    PRIMARY KEY(idTipo)
);

CREATE TABLE estadosCreditos(
	idEstado INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(100),
    PRIMARY KEY(idEstado)
);

CREATE TABLE creditos(
	idCredito INT AUTO_INCREMENT NOT NULL,
    ciUsuario VARCHAR(10) NULL,
    idTipo INT NULL,
    idEstado INT NULL,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    fechaCredito DATE NULL,
    valor FLOAT NULL,
    cuotas INT NULL,
    interes FLOAT NULL,
    totalPagar FLOAT NULL,
    descripcion VARCHAR(100) NULL,
    cuotasPagadas INT NULL,
    PRIMARY KEY(idCredito),
    FOREIGN KEY(ciUsuario) REFERENCES usuariosSistema (ciUsuario),
    FOREIGN KEY(idTipo) REFERENCES tiposCreditos (idTipo),
    FOREIGN KEY(idEstado) REFERENCES estadosCreditos (idEstado)
);

CREATE TABLE tiposPagos(
	idTipo INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(100),
    PRIMARY KEY(idTipo)
);

CREATE TABLE pagos(
	idPago INT AUTO_INCREMENT NOT NULL,
    idTipo INT NULL,
    fechaPago DATE NULL,
    valor FLOAT NULL,
    PRIMARY KEY(idPago),
	FOREIGN KEY(idTipo) REFERENCES tiposPagos (idTipo)
);

CREATE TABLE creditosPagos(
	idCredito INT NULL,
    idPago INT NULL,
    FOREIGN KEY(idCredito) REFERENCES creditos (idCredito),
    FOREIGN KEY(idPago) REFERENCES pagos (idPago)
);

CREATE TABLE tiposMultas(
	idTipo INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(100),
    PRIMARY KEY(idTipo)
);

CREATE TABLE multas(
	idMulta INT AUTO_INCREMENT NOT NULL,
    idTipo INT NULL,
    fechaMulta DATE NULL,
    valor FLOAT NULL,
    PRIMARY KEY(idMulta),
	FOREIGN KEY(idTipo) REFERENCES tiposMultas (idTipo)
);

CREATE TABLE creditosMultas(
	idCredito INT NULL,
    idMulta INT NULL,
    FOREIGN KEY(idCredito) REFERENCES creditos (idCredito),
    FOREIGN KEY(idMulta) REFERENCES multas (idMulta)
);








