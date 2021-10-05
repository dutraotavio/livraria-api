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

import br.com.otavio.livraria.dto.UsuarioDto;
import br.com.otavio.livraria.dto.UsuarioFormDto;
import br.com.otavio.livraria.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

          @Autowired
          private UsuarioService usuarioService;

          @GetMapping
          public Page<UsuarioDto> listar(@PageableDefault(size = 10) Pageable pageable) {
                    return usuarioService.listar(pageable);

          }

          @PostMapping()
          public void cadastrar(@RequestBody @Valid UsuarioFormDto dto) {
                    usuarioService.cadastrar(dto);
          }

}
