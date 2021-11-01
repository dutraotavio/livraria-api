package br.com.otavio.livraria.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import br.com.otavio.livraria.modelo.Autor;
import br.com.otavio.livraria.repository.AutorRepository;
import br.com.otavio.livraria.service.LivroService;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class LivroResourceTest {

          @Autowired
          private MockMvc mvc;

          @Autowired
          private AutorRepository autorRepository;

          @InjectMocks
          private LivroService livroService;

          @Test
          public void naoDeveriaCadastrarUsuarioComDadosIncompletos() throws Exception {
                    String json = "{}";

                    mvc.perform(MockMvcRequestBuilders.post("/livros").contentType(MediaType.APPLICATION_JSON)
                                        .content(json)).andExpect(MockMvcResultMatchers.status().isBadRequest());
          }

          @Test
          public void deveriaCadastrarUsuarioComDadosIncompletos() throws Exception {

                    Autor autor = new Autor("Cleide Silva", "cleide@gmail.com", LocalDate.now(),
                                        "Teste cadastro incompleto");
                    autorRepository.save(autor);

                    String json = "{\"titulo\":\"Teste cadastro incompleto\",\"dataDeLancamento\" : \"05/03/1992\",\"paginas\" : \"110\",\"autor_id\" :"
                                        + autor.getId() + " ,\"autor\" : {\"nome\": \"Cleide Silva\"}}";

                    String jsonRetorno = "{\"id\":34 ,\"titulo\": \"Teste cadastro incompleto\",\"dataDeLancamento\": \"05/03/1992\",\"paginas\": 110,\"autor\": {\"nome\": \"Cleide Silva\",\"email\": \"cleide@gmail.com\",\"dataDeNascimento\": \"01/11/2021\"}}";

                    mvc.perform(MockMvcRequestBuilders.post("/livros").contentType(MediaType.APPLICATION_JSON)
                                        .content(json)).andExpect(MockMvcResultMatchers.status().isCreated())
                                        .andExpect(MockMvcResultMatchers.header().exists("Location"))
                                        .andExpect(MockMvcResultMatchers.content().json(jsonRetorno));
          }

}