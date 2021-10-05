package br.com.otavio.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
          public List<AutorDto> listar() {
                    return autorService.listar();
          }

          @PostMapping
          public void cadastrar(@RequestBody @Valid AutorFormDto dto) {
                    autorService.cadastrar(dto);
          }

}
