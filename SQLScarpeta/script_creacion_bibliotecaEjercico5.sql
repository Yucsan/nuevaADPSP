DROP DATABASE biblioteca;
create database biblioteca;
use biblioteca;
CREATE TABLE `libros` (
  isbn varchar(10) ,
  titulo varchar(50) DEFAULT NULL,
  autor varchar(50) DEFAULT NULL,
  prestado TINYINT   DEFAULT FALSE,
   PRIMARY KEY (`isbn`)
);

CREATE TABLE socios (
	id_socio INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(32) NOT NULL,
	apellidos VARCHAR(64) NOT NULL,
	PRIMARY KEY (id_socio)
);

CREATE TABLE prestamos (
	id_socio INT ,
	isbn VARCHAR(10) ,
	fecha_prestamo DATE ,
	PRIMARY KEY (id_socio,isbn,fecha_prestamo),
        FOREIGN KEY (id_socio) REFERENCES socios(id_socio),
	FOREIGN KEY (isbn) REFERENCES libros(isbn)
);


insert into`libros` (isbn,titulo,autor) values  ('l1','libro1','autor1');
insert into`libros` (isbn,titulo,autor) values  ('l2','libro2','autor2');
insert into`libros` (isbn,titulo,autor) values  ('l3','libro3','autor3');
insert into`libros` (isbn,titulo,autor) values  ('l4','libro4','autor4');
insert into`libros` (isbn,titulo,autor) values  ('l5','libro5','autor5');


INSERT INTO socios VALUES
    (1,'Javier','Sánchez'),
    (2,'Teresa','López'),
    (3,'Agustín','Domínguez');


INSERT INTO prestamos VALUES
    (1,'l2','2013-02-18'),
    (1,'l2','2016-03-15'),
    (2,'l3','2016-03-15'),
    (3,'l4','2016-03-15');
commit;
