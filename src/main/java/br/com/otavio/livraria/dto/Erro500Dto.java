package br.com.otavio.livraria.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Erro500Dto {

          private LocalDateTime timeStamp;
          private String erro;
          private String mensagem;
          private String path;
}
