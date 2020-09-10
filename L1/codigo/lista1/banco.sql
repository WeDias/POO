--
-- File generated with SQLiteStudio v3.2.1 on dom set 6 15:23:06 2020
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: clientes
CREATE TABLE clientes (idCliente INTEGER PRIMARY KEY ASC AUTOINCREMENT, nome TEXT NOT NULL, telefone TEXT (11) DEFAULT NULL, dataNasc DATE (10) NOT NULL, genero TEXT (1) DEFAULT NULL);
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (1, 'PEDRO', '12988000000', '2000-01-01', 'M');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (2, 'WESLEY', '12988681287', '2000-10-05', 'M');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (3, 'THIAGO', '12988156299', '1986-06-16', 'M');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (4, 'ANA', '12968681220', '1999-12-04', 'F');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (5, 'JULIA', '12988124065', '2002-12-01', 'F');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (6, 'BRUNA', '12989310869', '1990-05-26', 'F');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (11, 'JULIO', '12988463187', '1975-06-08', 'M');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (15, 'BENTO REIS', '1294461873', '1985-06-25', 'M');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (17, 'BEATRIZ', '12988476108', '2001-01-05', 'F');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (18, 'CAROLINA', '12988315891', '1999-12-21', 'F');
INSERT INTO clientes (idCliente, nome, telefone, dataNasc, genero) VALUES (19, 'TESTE', '12000000000', '1990-10-01', 'M');

-- Table: servPrest
CREATE TABLE servPrest (idServ INTEGER PRIMARY KEY ASC AUTOINCREMENT UNIQUE NOT NULL, dataHora DATETIME NOT NULL, idCliente INTEGER REFERENCES clientes (idCliente) NOT NULL, idTipoServ INTEGER NOT NULL REFERENCES tipoServ (idTipoServ));
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (1, '2020-09-04 12:45:15', 1, 12);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (2, '2020-09-04 13:00:06', 2, 4);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (3, '2020-09-04 13:30:09', 1, 14);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (4, '2020-09-04 13:35:36', 4, 5);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (5, '2020-09-04 13:50:15', 5, 2);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (6, '2020-09-04 14:45:15', 3, 11);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (7, '2020-09-04 14:50:35', 5, 10);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (8, '2020-09-04 15:00:00', 4, 8);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (9, '2020-09-04 15:55:32', 2, 13);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (10, '2020-09-04 16:25:52', 3, 4);
INSERT INTO servPrest (idServ, dataHora, idCliente, idTipoServ) VALUES (11, '2020-09-04 15:50:15', 5, 2);

-- Table: tipoServ
CREATE TABLE tipoServ (idTipoServ INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL UNIQUE, nomeServ TEXT UNIQUE NOT NULL);
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (1, 'manicure');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (2, 'pedicure');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (3, 'design de sobrancelhas');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (4, 'corte de cabelos');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (5, 'pintura de cabelos');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (6, 'remoção de rugas');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (7, 'remoção de
manchas na pele');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (8, 'aplicação de botox');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (9, 'tratamento para emagrecimento');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (10, 'redução de medidas');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (11, 'modelagem de barba');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (12, 'corte de barba');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (13, 'tratamento para quedas de cabelo');
INSERT INTO tipoServ (idTipoServ, nomeServ) VALUES (14, 'venda de produtos especializados');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
