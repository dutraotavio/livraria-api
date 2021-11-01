package br.com.otavio.livraria.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otavio.livraria.dto.LivroDto;
import br.com.otavio.livraria.dto.LivroFormDto;
import br.com.otavio.livraria.repository.AutorRepository;
import br.com.otavio.livraria.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

          @Mock
          private LivroRepository livroRepository;

          @Mock
          private AutorRepository autorRepository;

          @InjectMocks
          private LivroService livroService;

          @Test
          void deveriaCadastrarUmLivro() {
                    LivroFormDto livroFormDto = new LivroFormDto("Teste titulo do livro", LocalDate.now(), 500, 1l);

                    LivroDto dto = livroService.cadastrar(livroFormDto);

                    // Mockito.verify(livroRepository.save(Mockito.any()));

                    assertEquals(livroFormDto.getTitulo(), dto.getTitulo());
                    assertEquals(livroFormDto.getPaginas(), dto.getPaginas());
          }

          @Test
          void naoDeveriaCadastrarLivroComUserInexistente() {
                    LivroFormDto livroFormDto = new LivroFormDto("Testando titulo do livro", LocalDate.now(), 400,
                                        9999l);

                    Mockito.when(autorRepository.getById(livroFormDto.getAutorId()))
                                        .thenThrow(EntityNotFoundException.class);

                    Assertions.assertThrows(IllegalArgumentException.class, () -> livroService.cadastrar(livroFormDto));
          }
}
