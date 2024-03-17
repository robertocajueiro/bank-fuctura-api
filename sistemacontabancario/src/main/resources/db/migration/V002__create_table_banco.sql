create table tbl_banco(
	id serial primary key not null,
	nome varchar(50) not null,
	cnpj varchar(50) not null,
	presidente varchar(50)
)