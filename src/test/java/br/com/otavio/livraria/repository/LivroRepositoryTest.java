package br.com.otavio.livraria.repository;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.otavio.livraria.dto.ItemLivroDto;
import br.com.otavio.livraria.modelo.Autor;
import br.com.otavio.livraria.modelo.Livro;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

          @Autowired
          private LivroRepository repository;

          @Autowired
          private TestEntityManager em;

          @Test
          void deveriaRetornarRelatorioLivro() {
                    Autor autor1 = new Autor("Marcos", "marquito@gmail.com", LocalDate.now(),
                                        "Teste curriculo autor 1");
                    em.persist(autor1);

                    Autor autor2 = new Autor("Guilherme", "gui@gmail.com", LocalDate.now(), "Teste curriculo autor 2");
                    em.persist(autor2);

                    Autor autor3 = new Autor("Jonas", "jonas@gmail.com", LocalDate.now(), "Teste curriculo autor 3");
                    em.persist(autor3);

                    Autor autor4 = new Autor("Mario", "mario@gmail.com", LocalDate.now(), "Teste curriculo autor 4");
                    em.persist(autor4);

                    Autor autor5 = new Autor("Cleide", "cleide@gmail.com", LocalDate.now(), "Teste curriculo autor 5");
                    em.persist(autor5);

                    Livro l1 = new Livro("Aprenda Java em 21 dias", LocalDate.now(), 130, autor1);
                    em.persist(l1);

                    Livro l2 = new Livro("Como ser mais produtivo ", LocalDate.now(), 150, autor2);
                    em.persist(l2);

                    Livro l3 = new Livro("Aprenda a falar em público", LocalDate.now(), 170, autor3);
                    em.persist(l3);

                    Livro l4 = new Livro("Otimizando seu tempo", LocalDate.now(), 200, autor2);
                    em.persist(l4);

                    Livro l5 = new Livro("Como fazer bolos incríveis", LocalDate.now(), 230, autor4);
                    em.persist(l5);

                    Livro l6 = new Livro("Investindo em ações na bolsa de valores", LocalDate.now(), 250, autor5);
                    em.persist(l6);

                    Livro l7 = new Livro("Aprenda Python em 12 dias", LocalDate.now(), 270, autor1);
                    em.persist(l7);

                    List<ItemLivroDto> itemLivroDtos = repository.relatorioDeLivros();
                    Assertions.assertThat(itemLivroDtos).hasSize(5)
                                        .extracting(ItemLivroDto::getAutor, ItemLivroDto::getQuantidadeDeLivros,
                                                            ItemLivroDto::getPercentual)
                                        .containsExactlyInAnyOrder(Assertions.tuple("Marcos", 2l, 0.285714),
                                                            Assertions.tuple("Guilherme", 2l, 0.285714),
                                                            Assertions.tuple("Jonas", 1l, 0.142857),
                                                            Assertions.tuple("Mario", 1l, 0.142857),
                                                            Assertions.tuple("Cleide", 1l, 0.142857));
          }

}
