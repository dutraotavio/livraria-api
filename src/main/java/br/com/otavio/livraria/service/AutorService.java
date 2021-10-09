package br.com.otavio.livraria.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

          public Page<AutorDto> listar(Pageable pageable) {
                    Page<Autor> autores = autorRepository.findAll(pageable);
                    return autores.map(a -> modelMapper.map(a, AutorDto.class));
          }

          @Transactional
          public AutorDto cadastrar(AutorFormDto dto) {
                    Autor autor = modelMapper.map(dto, Autor.class);
                    autorRepository.save(autor);

                    return modelMapper.map(autor, AutorDto.class);
          }
}
