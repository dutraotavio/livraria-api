package br.com.otavio.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otavio.livraria.dto.ItemLivroDto;
import br.com.otavio.livraria.service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

          @Autowired
          private RelatorioService service;

          @GetMapping("/livros")
          public List<ItemLivroDto> relatorioDeLivros() {
                    return service.relatorioDeLivros();
          }

}
