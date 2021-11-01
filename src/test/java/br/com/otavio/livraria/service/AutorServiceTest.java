package br.com.otavio.livraria.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otavio.livraria.dto.AutorDto;
import br.com.otavio.livraria.dto.AutorFormDto;
import br.com.otavio.livraria.repository.AutorRepository;
import br.com.otavio.livraria.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {

          @Mock
          private LivroRepository livroRepository;

          @Mock
          private AutorRepository autorRepository;

          @InjectMocks
          private AutorService autorService;

          @Test
          void deveriaCadastrarUmAutor() {
                    AutorFormDto autorFormDto = new AutorFormDto("Joao Cleber", "jao@gmail.com", LocalDate.now(),
                                        "Joao Cleber - Para, para, para!");

                    AutorDto dto = autorService.cadastrar(autorFormDto);

                    Assertions.assertEquals(autorFormDto.getNome(), dto.getNome());
                    Assertions.assertEquals(autorFormDto.getEmail(), dto.getEmail());
                    Assertions.assertEquals(autorFormDto.getDataDeNascimento(), dto.getDataDeNascimento());

          }

}
