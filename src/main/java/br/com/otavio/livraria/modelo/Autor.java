package br.com.otavio.livraria.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "curriculo" })
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private LocalDate dataDeNascimento;
	private String curriculo;

	public Autor(String nome, String email, LocalDate dataDeNascimento, String curriculo) {
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.curriculo = curriculo;
	}

	public void atualizarInformacoes(String nome, String email, LocalDate dataDeNascimento, String curriculo) {
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.curriculo = curriculo;
	}
}
