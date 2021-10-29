package br.com.otavio.livraria.service;

import java.util.Random;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.otavio.livraria.dto.UsuarioDto;
import br.com.otavio.livraria.dto.UsuarioFormDto;
import br.com.otavio.livraria.modelo.Usuario;
import br.com.otavio.livraria.repository.UsuarioRepository;

@Service
public class UsuarioService {

          @Autowired
          private UsuarioRepository usuarioRepository;
          private ModelMapper modelMapper = new ModelMapper();

          public Page<UsuarioDto> listar(Pageable pageable) {
                    Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
                    return usuarios.map(u -> modelMapper.map(u, UsuarioDto.class));
          }

          @Transactional
          public void cadastrar(UsuarioFormDto dto) {

                    Usuario usuario = modelMapper.map(dto, Usuario.class);

                    String senha = new Random().nextInt(999999) + "";
                    usuario.setSenha(senha);
                    usuarioRepository.save(usuario);
          }

}
