package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

          private String titulo;
          @JsonFormat(pattern = "dd/MM/yyyy")
          private LocalDate dataDeLancamento;
          private Integer paginas;
          private AutorDto autor;
}