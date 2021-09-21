package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

          private String titulo;
          private LocalDate dataDeLancamento;
          private Integer paginas;
          private AutorDto autor;
}