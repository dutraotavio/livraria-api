CREATE table autores(
          id bigint not null auto_increment,
          nome varchar(100) not null,
          email varchar(100) not null,
          dataDeNascimento date not null,
          curriculo varchar(255) not null,
          primary key (id)
);