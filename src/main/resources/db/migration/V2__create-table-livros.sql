CREATE table livros(
          id bigint not null auto_increment,
          titulo varchar(255) not null,
          dataDeLancamento date not null,
          paginas int not null,
          autor_id bigint not null,
          primary key (id),
          foreign key (autor_id) references autores(id)
);