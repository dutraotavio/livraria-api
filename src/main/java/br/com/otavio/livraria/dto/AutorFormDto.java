package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {

          @NotBlank
          private String nome;

          @NotBlank
          @Email
          private String email;

          @NotNull
          @Past
          @JsonFormat(pattern = "dd/MM/yyyy")
          private LocalDate dataDeNascimento;

          @NotBlank
          @Size(min = 10, max = 100)
          private String curriculo;
}