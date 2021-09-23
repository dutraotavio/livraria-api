package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.otavio.livraria.modelo.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFormDto {

          @NotBlank
          @Size(min = 10, max = 30)
          private String titulo;

          @NotNull
          @PastOrPresent
          @JsonFormat(pattern = "dd/MM/yyyy")
          private LocalDate dataDeLancamento;

          @NotNull
          @Positive
          @DecimalMin(value = "100")
          private int paginas;

          @NotNull
          private Autor autor;

}