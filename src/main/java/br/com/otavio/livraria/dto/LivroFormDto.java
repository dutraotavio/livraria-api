package br.com.otavio.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFormDto {

          @NotEmpty
          @Size(min = 10, max = 50)
          private String titulo;

          @NotNull
          @PastOrPresent
          @JsonAlias("data_de_lancamento")
          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
          private LocalDate dataDeLancamento;

          @NotNull
          @Positive
          @DecimalMin(value = "100")
          private Integer paginas;

          @JsonAlias("autor_id")
          private Long autorId;
}