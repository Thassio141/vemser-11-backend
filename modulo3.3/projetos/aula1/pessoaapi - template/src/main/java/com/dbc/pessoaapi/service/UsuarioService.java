package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    // FIXME construir métodos necessários para o usuário
    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> pegarLoginUsuario(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login , senha);
    }
}
