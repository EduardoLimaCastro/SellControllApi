CREATE TABLE suppliers(

    id bigint NOT NULL auto_increment,
    razaosocial varchar(150) not null,
    cnpj varchar(20) not null,
    telefone varchar(12) not null,
    logradouro varchar(80) not null,
    numero varchar(8) not null,
    complemento varchar(50) not null,
    bairro varchar(30) not null,
    cidade varchar(30) not null,
    uf varchar(2) not null,
    cep varchar(10) not null,

    primary key(id)

);