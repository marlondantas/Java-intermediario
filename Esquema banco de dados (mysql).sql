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

create table tbod_cargo(
	id_cargo int not null AUTO_INCREMENT,
    ds_carga varchar(50) not null,
    primary key(id_cargo)
);

create table tbod_funcionario (
	id_funcionario int not null AUTO_INCREMENT,
    nm_funcionario varchar(50) not null,
    nm_sobrenome varchar (50) not null,
    dt_nascimento date not null,
    ds_email varchar(50),
    id_cargo int not null,
    vl_salario numeric not null,
    
    primary key(id_funcionario ),
    CONSTRAINT fk_id_cargo FOREIGN KEY (id_cargo) REFERENCES tbod_cargo (id_cargo)
);

select * from tbod_funcionario;







