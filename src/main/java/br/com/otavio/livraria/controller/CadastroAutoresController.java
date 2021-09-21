package br.com.otavio.livraria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otavio.livraria.dto.AutorDto;
import br.com.otavio.livraria.dto.AutorFormDto;
import br.com.otavio.livraria.modelo.Autor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autores")
public class CadastroAutoresController {

          private List<Autor> autores = new ArrayList<>();
          private ModelMapper modelMapper = new ModelMapper();

          @GetMapping
          public List<AutorDto> listar() {
                    return autores.stream().map(t -> modelMapper.map(t, AutorDto.class)).collect(Collectors.toList());
          }

          @PostMapping
          public void cadastrar(@RequestBody @Valid AutorFormDto dto) {
                    Autor autor = modelMapper.map(dto, Autor.class);
                    autores.add(autor);
          }

}
