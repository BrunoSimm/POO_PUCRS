CREATE TABLE veiculos
(
    placa char(8),
    ano number(4),
    km number(6),
    marca varchar(50),
    modelo varchar(50)
);


INSERT INTO VEICULOS
    VALUES('IJK-1212',2012,0,'Chevrolet','Vectra');

SELECT * FROM veiculos; --seleciona tudo da tabela veiculos

INSERT INTO veiculos (placa,ano,km,marca,modelo)
    VALUES ('IJM-1556',2001,72045,'Volkswagen','Gol');
    
INSERT INTO veiculos (placa,ano,km,marca,modelo)
    VALUES ('IOP-1010',2021,0,'Volkswagen','Gol');
    
insert into veiculos (placa, ano, km, marca, modelo)
    values ('IXY-4890', 2018, 580, 'Tesla', 'Model 3');
    
insert into veiculos (placa, ano, km, marca, modelo)
    values ('IXY-4890', 2018, 580, 'Volkswagen', 'Jetta');
    
SELECT placa,ano,km 
    FROM veiculos;
    
SELECT marca,placa,ano,km
    FROM veiculos
    WHERE km = 0; -- condicional para apenas pegar os veiculos com km = 0
    
SELECT marca,ano,modelo
    FROM veiculos
    WHERE ano < 2012;
    
SELECT marca,ano,modelo
    FROM veiculos
    WHERE ano < 2012 AND marca = 'Honda'; --AND , OR e NOT

UPDATE veiculos
    SET modelo = 'Vectra Elite 2.0'
    WHERE placa = 'IJK-1212'; -- CASO NÃO INSERIR WHERE, IRÁ SETAR O MODELO PARA TODOS OS REGISTROS DA TABELA
    
SELECT * 
    FROM veiculos
    WHERE ano <> 2001; -- <> = Diferente
    
    
DELETE FROM veiculos
    WHERE placa = 'IJK-1212';

DELETE FROM veiculos
    WHERE marca = 'Chevrolet' AND km > 90000;
    
UPDATE veiculos
    SET modelo='Gol bola'
    WHERE placa = 'IJM-1556';
    
UPDATE veiculos
    SET modelo = 'Gol bola2', km = 50, ano = 2005
    WHERE placa = 'IJM-1556';
    


--- isto é um comentario