package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {

          private String nome;
          private String email;
          private LocalDate dataDeNascimento;
          private String curriculo;

}