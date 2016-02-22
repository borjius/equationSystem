create table EQUATION (
	ID int not null,
	AUTHOR varchar(30) not null,
	DESCRIPTION varchar(100) not null
);

create table SYMBOL (
	SYMBOL varchar(10) not null,
	OPERATION varchar(10) not null,
	DESCRIPTION varchar(100) not null
);