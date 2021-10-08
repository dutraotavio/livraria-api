package br.com.otavio.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otavio.livraria.dto.LivroDto;
import br.com.otavio.livraria.dto.LivroFormDto;
import br.com.otavio.livraria.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivrosController {

          @Autowired
          private LivroService service;

          @GetMapping
          public Page<LivroDto> listar(@PageableDefault(size = 10) Pageable pageable) {
                    return service.listar(pageable);
          }

          @PostMapping
          public void cadastrar(@RequestBody @Valid LivroFormDto dto) {
                    service.cadastrar(dto);
          }

}
