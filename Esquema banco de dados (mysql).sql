create database cursoJava;

use cursoJava;

create table tbod_carro(
	id_carro int not null AUTO_INCREMENT,
    nm_carro varchar(50),
    nm_modelo varchar(50),
    nm_motor varchar(50),
    nm_fabricante varchar(50),
    dt_fabricacao date,
    dt_ano_modelo date,
    cor  varchar(50),
    
    primary key(id_carro)
);

select * from tbod_carro;

insert into tbod_carro values (NULL,'IDEIA','ATRATIVCTE','1.4','FIAT',STR_TO_DATE("01/01/2011", "%d/%m/%Y"),STR_TO_DATE("01/01/2010", "%d/%m/%Y"),'AZUL');
insert into tbod_carro values (NULL,'FIT','ATRATIVCTE','1.5 VTEC','HONDA',STR_TO_DATE("01/01/2015", "%d/%m/%Y"),STR_TO_DATE("01/01/2012", "%d/%m/%Y"),'PRETO');








