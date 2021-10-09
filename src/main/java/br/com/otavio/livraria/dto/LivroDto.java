package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

          private Long id;
          private String titulo;

          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
          private LocalDate dataDeLancamento;
          private Integer paginas;
          private AutorDto autor;
}