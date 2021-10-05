package br.com.otavio.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.otavio.livraria.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}