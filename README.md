# Agenda
Uma simples agenda simples feita em Swing.

Usado banco de Dados Postgre com PGAdmin III
Passos para criação do Banco:

Criar usuário:

create user agenda with password 'agenda'

Criar database:

create database agenda with owner agenda

Criar tabela:

create tabla cliente (
	id serial primary key,
	nome varchar(100),
	telFixo varchar(14),
	telCel varchar(14),
	email varchar(100)
);
