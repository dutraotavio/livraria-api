package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutorDto {

          private Long id;
          private String nome;
          private String email;

          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
          private LocalDate dataDeNascimento;
          private String curriculo;
}