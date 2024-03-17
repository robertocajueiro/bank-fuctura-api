create table tbl_conta_corrente(
	id serial primary key not null,
	nome numeric not null,
	saldo float,
	FOREIGN KEY(id) references tbl_usuario(id)
)