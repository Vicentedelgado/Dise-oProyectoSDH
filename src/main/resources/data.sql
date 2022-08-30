INSERT INTO users (username,password,enabled) VALUES ('admin', '$2a$10$C4ynSHX9PbzjnWSv8m0IheEq8obya43LpWihipQytaIOP4IJ35j1a', '1');
INSERT INTO users (username,password,enabled) VALUES ('user', '$2a$10$OUhbBtdOR.neHhBcHPVg7O37Gl6bSCCP.7RTHbHspxKNDlgSRZnXi', '1');
INSERT INTO users (username,password,enabled) VALUES ('visitor', '$$2a$10$C80cDIVa0JQX6WNnUHD5ze06J3B2TsWB9GoT/QIEgjj.oKyU6g5Z.', '1');
INSERT INTO roles (user_id, rol) VALUES (1,'ROLE_ADMIN');
INSERT INTO roles (user_id, rol) VALUES (1,'ROLE_USER');
INSERT INTO roles (user_id, rol) VALUES (1,'ROLE_VISITOR');
INSERT INTO roles (user_id, rol) VALUES (2,'ROLE_USER');
INSERT INTO roles (user_id, rol) VALUES (3,'ROLE_VISITOR');

INSERT INTO tipo (idtipo,descripcion, nombre) values (1,'tipo','Instalaciones');
INSERT INTO tipo (idtipo,descripcion, nombre) values (2,'tipo','Bienes');
INSERT INTO tipo (idtipo,descripcion, nombre) values (3,'tipo','Equipos');
INSERT INTO tipo (idtipo,descripcion, nombre) values (4,'tipo','Otros');
INSERT INTO tipo (idtipo,descripcion, nombre) values (5,'tipo','Movilidad');
INSERT INTO tipo (idtipo,descripcion, nombre) values (6,'tipo','Conectividad');

insert into activo (descripcion,nombre,idtipo) values ('activo','Cuadro misión-visión','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Iluminación eléctrica','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Iluminación natural','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Servicio de limpieza','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Rótulo','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Seguridad','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Servicios básicos','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Ventilación natural','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Vigilancia','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Parqueadero','1');
insert into activo (descripcion,nombre,idtipo) values ('activo','Anaqueles','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Archivadores','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Estación de trabajo','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Estanterías','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Papelera','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Sillas de visita','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Sillas giratorias','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Ventiladores','2');
insert into activo (descripcion,nombre,idtipo) values ('activo','Computadoras','3');
insert into activo (descripcion,nombre,idtipo) values ('activo','Impresoras','3');
insert into activo (descripcion,nombre,idtipo) values ('activo','Teléfono','3');
insert into activo (descripcion,nombre,idtipo) values ('activo','Banner','4');
insert into activo (descripcion,nombre,idtipo) values ('activo','Chompa','4');
insert into activo (descripcion,nombre,idtipo) values ('activo','Pizarra','4');
insert into activo (descripcion,nombre,idtipo) values ('activo','Vehículo','5');
insert into activo (descripcion,nombre,idtipo) values ('activo','Moto','5');
insert into activo (descripcion,nombre,idtipo) values ('activo','Coordinación de movilidad','5');
insert into activo (descripcion,nombre,idtipo) values ('activo','Internet','6');

insert into zona (idzona,nombre) values (1,'Zona 1');
insert into zona (idzona,nombre) values (2,'Zona 2');
insert into zona (idzona,nombre) values (3,'Zona 3');
insert into zona (idzona,nombre) values (4,'Zona 4');
insert into zona (idzona,nombre) values (5,'Zona 5');
insert into zona (idzona,nombre) values (6,'Zona 6');
insert into zona (idzona,nombre) values (7,'Zona 7');
insert into zona (idzona,nombre) values (8,'Zona 8');
insert into zona (idzona,nombre) values (9,'Zona 9');

insert into unidad (nombre) values ('Trabajo Social');
insert into unidad (nombre) values ('Psicología');
insert into unidad (nombre) values ('SIN DEFINIR');

insert into modalidad (nombre) values ('Cotrato Ocacional');
insert into modalidad (nombre) values ('Nombramiento Provicional');
insert into modalidad (nombre) values ('Nombramiento');
insert into modalidad (nombre) values ('Comisión de Servicios');
insert into modalidad (nombre) values ('SD');

insert into institucion (nombre) values('SDH');
insert into institucion (nombre) values('MIES');

insert into spi_datos (idspi,archivo,convenio,daservicioa,direccion,fechafinconvenio,nombre,numerodeoficina,observaciones,telefono,idinstitucion,idzona) values (1,'vacio_sdh.pdf','SD','Ibarra, Urcuquí, Pimampiro','Sánchez Cifuentes y Velasco, Edif. Banco La Previsora','2021-10-31 00:00:00','Ibarra',1,'Vigente convenio hasta agosto 2020','062505289',1,1);

insert into funcionario (apellidos,cargo,cedula,direccion,email,estado,nombres,telefono,idmodalidad,idspi,idunidad,idzona) values ('Delgado Ruiz','Doctor','1725596808','Quito','vicen@gmail.com','Activo','David Daniel','258964',1,1,1,1);

insert into registro_del_spi (accionrealizada,archivo,cantidad,cantidadrequerida,estado,fechaaccion,holguradecantidad,observaciones,periodo,prioridad,idactivo,idinstitucion,idspi) values ('ninguna','vacio_sdh.pdf',1,2,'Regular','2021-10-31 00:00:00',1,'ninguna','2022','Alta',1,1,1);

