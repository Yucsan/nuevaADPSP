-- DROP DATABASE IF EXISTS programadores;

CREATE DATABASE programadores;
USE programadores;

CREATE TABLE programador (
  idpro INTEGER AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  telefono VARCHAR(12),
  direccion VARCHAR(50),
  ciudad VARCHAR(50),
  cp INT
);

CREATE TABLE proyecto (
  idproye INTEGER AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(32) NOT NULL UNIQUE,
  tecnologia VARCHAR(30),
  pais VARCHAR(20)
);

CREATE TABLE empresa (
  idempre INTEGER AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(80) NOT NULL,
  cif VARCHAR(12),
  idproye_FK INTEGER NOT NULL, 
  idpro_FK INTEGER NOT NULL, 
  FOREIGN KEY (idproye_FK) REFERENCES proyecto(idproye),
  FOREIGN KEY (idpro_FK) REFERENCES programador(idpro)
);

INSERT INTO programador (nombre, telefono, direccion, ciudad, cp)
VALUES
  ('Juan Pérez', '1234567890', 'Calle Falsa 123', 'Madrid', 28001),
  ('Ana López', '1234567891', 'Calle Sol 456', 'Barcelona', 08001),
  ('Luis Martínez', '1234567892', 'Avenida Luna 789', 'Valencia', 46001),
  ('María García', '1234567893', 'Plaza Mayor 101', 'Sevilla', 41001),
  ('Pedro Sánchez', '1234567894', 'Calle Estrella 202', 'Bilbao', 48001);

INSERT INTO proyecto (nombre, tecnologia, pais)
VALUES
  ('Proyecto Alpha', 'Java', 'España'),
  ('Proyecto Beta', 'Python', 'España'),
  ('Proyecto Gamma', 'ReactJS', 'Portugal');

INSERT INTO empresa (titulo, cif, idproye_FK, idpro_FK)
VALUES
  ('Tech Solutions', 'CIF123456', 1, 1), -- Relación inicial con proyecto 1 y programador 1
  ('Innovatech', 'CIF654321', 3, 3);    -- Relación inicial con proyecto 3 y programador 3

INSERT INTO empresa (titulo, cif, idproye_FK, idpro_FK)
VALUES
  ('Tech Solutions', 'CIF123456', 1, 2), -- Programador 2
  ('Tech Solutions', 'CIF123456', 1, 3); -- Programador 3

INSERT INTO empresa (titulo, cif, idproye_FK, idpro_FK)
VALUES
  ('Tech Solutions', 'CIF123456', 2, 4), -- Programador 4
  ('Tech Solutions', 'CIF123456', 2, 5); -- Programador 5



