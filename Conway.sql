create database Project;
use Project;
create table state (
	SName varchar(50) unique
);
create table Cell (
	SName varchar(50) not null,
	id int primary key,
    C_Row int  primary key not null,
    C_Col int  primary key not null,
	CONSTRAINT FK_CellState foreign key (SName) references state(SName)
);
create table Board (
	SName varchar(50) not null,
    B_Row int primary key not null,
    B_Col int primary key not null,
	CONSTRAINT FK_CellState foreign key (SName) references state(SName)
);
