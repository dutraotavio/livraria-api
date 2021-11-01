package br.com.otavio.livraria.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class AutorResourceTest {

          @Autowired
          private MockMvc mvc;

          @Test
          public void naoDeveriaCadastrarUsuarioComDadosIncompletos() throws Exception {
                    String json = "{}";

                    mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON)
                                        .content(json)).andExpect(MockMvcResultMatchers.status().isBadRequest());
          }

          @Test
          public void deveriaCadastrarUsuarioComDadosIncompletos() throws Exception {
                    String json = "{\"nome\":\"Cleide Silva\",\"email\":\"cleide@gmail.com\",\"dataDeNascimento\":\"05/03/1992\",\"curriculo\":\"Teste cadastro autor com dados incompletos\"}";
                    String jsonRetorno = "{\"nome\":\"Cleide Silva\",\"email\":\"cleide@gmail.com\",\"dataDeNascimento\":\"05/03/1992\"}";

                    mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON)
                                        .content(json)).andExpect(MockMvcResultMatchers.status().isCreated())
                                        .andExpect(MockMvcResultMatchers.header().exists("Location"))
                                        .andExpect(MockMvcResultMatchers.content().json(jsonRetorno));
          }

}
