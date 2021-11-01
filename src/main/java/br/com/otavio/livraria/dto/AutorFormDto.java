package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorFormDto {

          @NotBlank
          @Size(min = 5)
          private String nome;

          @NotBlank
          @Email
          private String email;

          @Past
          @NotNull
          @JsonAlias("data_de_nascimento")
          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
          private LocalDate dataDeNascimento;

          @NotBlank
          @Size(min = 10, max = 255)
          private String curriculo;
}