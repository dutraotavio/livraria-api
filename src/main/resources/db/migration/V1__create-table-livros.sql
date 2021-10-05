CREATE table livros(
          id bigint not null auto_increment,
          titulo varchar(100) not null,
          dataDeLancamento date not null,
          paginas int not null,
          autor varchar(100) not null,
          primary key (id)
);