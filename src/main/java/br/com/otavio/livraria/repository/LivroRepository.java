package br.com.otavio.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.otavio.livraria.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}