package br.com.otavio.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.otavio.livraria.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
