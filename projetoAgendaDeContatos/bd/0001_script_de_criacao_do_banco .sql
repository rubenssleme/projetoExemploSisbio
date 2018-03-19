CREATE DATABASE bdAgendaDeContatos1;

USE bdAgendaDeContatos1;

DROP DATABASE bdAgendaDeContatos1;

CREATE TABLE contatos(
id int identity not null,
nome varchar(35) not null,
endereco varchar(30) not null,
telefone varchar(13) not null,
eMail varchar(35) not null,
PRIMARY KEY(id),
);

SELECT * FROM contatos;