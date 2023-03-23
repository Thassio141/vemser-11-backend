package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;
    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    // FIXME CRIAR FIND POR LOGIN
    public Optional<UsuarioEntity> findByLogin(String login){
        return  usuarioRepository.findByLogin(login);
    }
}
