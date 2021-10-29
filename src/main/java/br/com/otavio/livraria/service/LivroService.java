package br.com.otavio.livraria.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.otavio.livraria.dto.LivroDto;
import br.com.otavio.livraria.dto.LivroFormDto;
import br.com.otavio.livraria.modelo.Livro;
import br.com.otavio.livraria.repository.LivroRepository;

@Service
public class LivroService {

          @Autowired
          private LivroRepository livroRepository;
          private ModelMapper modelMapper = new ModelMapper();

          public Page<LivroDto> listar(Pageable pageable) {
                    Page<Livro> livros = livroRepository.findAll(pageable);
                    return livros.map(l -> modelMapper.map(l, LivroDto.class));
          }

          @Transactional
          public LivroDto cadastrar(LivroFormDto dto) {

                    Livro livro = modelMapper.map(dto, Livro.class);
                    livro.setId(null);

                    livroRepository.save(livro);
                    return modelMapper.map(livro, LivroDto.class);
          }
}
