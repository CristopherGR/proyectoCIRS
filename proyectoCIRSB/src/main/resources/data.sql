USE prueba2;

INSERT INTO tiposusuario(id_tipou, descripcion) VALUES (1, 'administrador');
INSERT INTO tiposusuario(id_tipou, descripcion) VALUES (2, 'empleado');
INSERT INTO tiposusuario(id_tipou, descripcion) VALUES (3, 'cliente');

INSERT INTO usuariossistema(ci_usuario, apellidos, correo, direccion, estado, fecha_na, nombres, `password`, telefono, id_tipou)
VALUES ('0202129441', 'Garcia', 'c@gmail.com', 'Guaranda', 'Pendiente', '2020-05-08', 'Cristopher', '1234', '0999138140', 1);
INSERT INTO usuariossistema(ci_usuario, apellidos, correo, direccion, estado, fecha_na, nombres, `password`, telefono, id_tipou)
VALUES ('0212524889', 'Medina', 'r@gmail.com', 'Riobamba', 'Pendiente', '2020-05-08', 'Raul', '1234', '0969514521', 2);

INSERT INTO tiposgastos(id_tipo, descripcion) VALUES (1, 'administrativo');
INSERT INTO tiposgastos(id_tipo, descripcion) VALUES (2, 'suministros');
INSERT INTO tiposgastos(id_tipo, descripcion) VALUES (3, 'publicidad');

INSERT INTO gastos(id_gasto, descripcion, fecha, valor, id_tipo) 
VALUES (150, 'compra de impresora', '2020-03-05', 200, 2);
INSERT INTO gastos(id_gasto, descripcion, fecha, valor, id_tipo) 
VALUES (222, 'pago alquiler mes de enero', '2020-01-01', 300, 1);

INSERT INTO tiposcreditos(id_tipo, descripcion) VALUES (1, 'largo plazo');
INSERT INTO tiposcreditos(id_tipo, descripcion) VALUES (2, 'corto plazo');

INSERT INTO estadoscreditos(id_estado, descripcion) VALUES (1, 'activo');
INSERT INTO estadoscreditos(id_estado, descripcion) VALUES (2, 'concluido');
INSERT INTO estadoscreditos(id_estado, descripcion) VALUES (3, 'atrasado');

INSERT INTO creditos(id_credito, cuotas, cuotas_pagadas, descripcion, fecha_credito, interes, total_pagar, valor, id_estado,
id_tipo) VALUES (1, 5, 2, 'credito de compra de alimento de animales', '2020-01-30', 3, 309, 300, 1, 1);
INSERT INTO creditos(id_credito, cuotas, cuotas_pagadas, descripcion, fecha_credito, interes, total_pagar, valor, id_estado,
id_tipo) VALUES (2, 3, 1, 'credito para compra de abono', '2020-03-15', 3, 123.6, 120, 1, 2);

INSERT INTO tipospagos(id_tipo, descripcion) VALUES (1, 'efectivo');
INSERT INTO tipospagos(id_tipo, descripcion) VALUES (2, 'cheque');
INSERT INTO tipospagos(id_tipo, descripcion) VALUES (3, 'transferencia');

INSERT INTO tiposmultas(id_tipo, descripcion) VALUES (1, 'atraso');
INSERT INTO tiposmultas(id_tipo, descripcion) VALUES (2, 'fraude');



