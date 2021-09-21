package br.com.otavio.livraria.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

          private String titulo;
          private LocalDate dataDeLancamento;
          private Integer paginas;
          private Autor autor;

}
