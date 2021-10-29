package br.com.otavio.livraria.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormDto {

          @NotBlank
          @Size(min = 3, max = 30)
          private String nome;

          @NotBlank(message = "Usuário inválido!")
          @Size(min = 8, max = 30)
          private String login;

          @Size(min = 0, max = 12)
          private String senha;

}
