package br.com.otavio.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.otavio.livraria.dto.ItemLivroDto;
import br.com.otavio.livraria.repository.LivroRepository;

@Service
public class RelatorioService {

          @Autowired
          private LivroRepository repository;

          public List<ItemLivroDto> relatorioDeLivros() {
                    return repository.relatorioDeLivros();
          }

}
