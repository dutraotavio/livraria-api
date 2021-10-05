package br.com.otavio.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otavio.livraria.dto.AutorDto;
import br.com.otavio.livraria.dto.AutorFormDto;
import br.com.otavio.livraria.service.AutorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autores")
public class CadastroAutoresController {

          @Autowired
          private AutorService autorService;

          @GetMapping
          public Page<AutorDto> listar(@PageableDefault(size = 10) Pageable pageable) {
                    return autorService.listar(pageable);
          }

          @PostMapping
          public void cadastrar(@RequestBody @Valid AutorFormDto dto) {
                    autorService.cadastrar(dto);
          }

}
