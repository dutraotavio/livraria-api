package br.com.otavio.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.otavio.livraria.dto.ItemLivroDto;
import br.com.otavio.livraria.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

          @Query("select new br.com.otavio.livraria.dto.ItemLivroDto(" + " a.nome, " + "count(l.titulo), "
                              + "count(l.titulo)* 1.0 /(select count(l1.titulo) from Livro l1) * 100.0)"
                              + " from Livro l inner join l.autor a " + " group by a.nome")

          List<ItemLivroDto> relatorioDeLivros();
}