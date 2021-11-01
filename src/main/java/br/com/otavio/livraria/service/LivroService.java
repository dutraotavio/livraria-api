package br.com.otavio.livraria.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.otavio.livraria.dto.AtualizacaoLivroFormDto;
import br.com.otavio.livraria.dto.LivroDto;
import br.com.otavio.livraria.dto.LivroFormDto;
import br.com.otavio.livraria.modelo.Autor;
import br.com.otavio.livraria.modelo.Livro;
import br.com.otavio.livraria.repository.AutorRepository;
import br.com.otavio.livraria.repository.LivroRepository;

@Service
public class LivroService {

          @Autowired
          private LivroRepository livroRepository;

          @Autowired
          private AutorRepository autorRepository;

          private ModelMapper modelMapper = new ModelMapper();

          public Page<LivroDto> listar(Pageable pageable) {
                    Page<Livro> livros = livroRepository.findAll(pageable);
                    return livros.map(l -> modelMapper.map(l, LivroDto.class));
          }

          @Transactional
          public LivroDto cadastrar(LivroFormDto dto) {

                    Livro livro = modelMapper.map(dto, Livro.class);
                    Long autorId = dto.getAutorId();
                    livro.setId(null);

                    try {
                              Autor autor = autorRepository.getById(autorId);

                              livro.setId(null);
                              livro.setAutor(autor);

                              livroRepository.save(livro);
                              return modelMapper.map(livro, LivroDto.class);
                    } catch (EntityNotFoundException e) {
                              throw new IllegalArgumentException("Autor inexistente!");
                    }

          }

          @Transactional
          public LivroDto atualizar(AtualizacaoLivroFormDto dto) {
                    Livro livro = livroRepository.getById(dto.getAutorId());

                    livro.atualizarInformacoes(dto.getTitulo(), dto.getDataDeLancamento(), dto.getPaginas());
                    return modelMapper.map(livro, LivroDto.class);
          }

          @Transactional
          public void remover(Long id) {
                    livroRepository.deleteById(id);
          }

          public LivroDto listarPorId(Long id) {
                    Livro livro = livroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
                    return modelMapper.map(livro, LivroDto.class);
          }
}
