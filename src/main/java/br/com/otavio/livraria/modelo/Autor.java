package br.com.otavio.livraria.modelo;

import java.time.LocalDate;

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
public class Autor {

	private String nome;
	private String email;
	private LocalDate dataDeNascimento;
	private String curriculo;
}
