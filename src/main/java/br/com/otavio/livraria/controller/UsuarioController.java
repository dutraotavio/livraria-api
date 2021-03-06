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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuario")
public class UsuarioController {

          @Autowired
          private UsuarioService service;

          @GetMapping
          @ApiOperation("Listar usuários")
          public Page<UsuarioDto> listar(@PageableDefault(size = 10) Pageable pageable) {
                    return service.listar(pageable);
          }

          @PostMapping()
          @ApiOperation("Cadastrar novo usuário")
          public void cadastrar(@RequestBody @Valid UsuarioFormDto dto) {
                    service.cadastrar(dto);
          }

}
