package br.com.otavio.livraria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.otavio.livraria.dto.AutorDto;
import br.com.otavio.livraria.dto.AutorFormDto;
import br.com.otavio.livraria.modelo.Autor;
import br.com.otavio.livraria.repository.AutorRepository;

@Service
public class AutorService {

          @Autowired
          private AutorRepository autorRepository;
          private ModelMapper modelMapper = new ModelMapper();

          public List<AutorDto> listar() {
                    List<Autor> autores = autorRepository.findAll();
                    return autores.stream().map(t -> modelMapper.map(t, AutorDto.class)).collect(Collectors.toList());
          }

          public void cadastrar(AutorFormDto dto) {
                    Autor autor = modelMapper.map(dto, Autor.class);

                    autorRepository.save(autor);
          }
}
