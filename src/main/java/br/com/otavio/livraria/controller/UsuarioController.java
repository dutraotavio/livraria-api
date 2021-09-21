package br.com.otavio.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.otavio.livraria.dto.UsuarioDto;
import br.com.otavio.livraria.dto.UsuarioFormDto;
import br.com.otavio.livraria.service.UsuarioService;

@RestController
public class UsuarioController {

          @Autowired
          private UsuarioService service;

          @GetMapping
          public List<UsuarioDto> listar() {
                    return service.listar();

          }

          @PostMapping()
          public void cadastrar(@RequestBody @Valid UsuarioFormDto dto) {
                    service.cadastrar(dto);
          }

}
