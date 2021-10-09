package br.com.otavio.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemLivroDto {

          private String autor;
          private Long quantidadeDeLivros;
          private Double percentual;
}
