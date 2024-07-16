CREATE TABLE topicos(
id bigint not null auto_increment,
titulo varchar(100) not null,
mensaje varchar(100) not null,
fecha_de_creacion VARCHAR(10) not null,
status tinyint not null,
autor varchar(100)not null,
nombre_curso varchar(100) not null,
categoria varchar(100) not null,

primary key (id)





);