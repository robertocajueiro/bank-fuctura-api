create table tbl_usuario(
	id serial primary key not null,
	nome varchar(50) unique not null,
	cpf varchar(20) unique not null,
	email varchar(50) unique not null,
	idade numeric
);

insert into tbl_usuario(nome, cpf, email, idade) values ('Roberto Dantas',  '00012345600','roberto@localhost', 42);