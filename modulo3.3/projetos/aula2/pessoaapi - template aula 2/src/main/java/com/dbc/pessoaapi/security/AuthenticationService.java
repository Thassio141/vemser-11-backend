package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService implements UserDetailsService {

    public AuthenticationService(@Lazy UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private final UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // FIXME buscar usuário pelo login
        return usuarioService.findByLogin(username).orElseThrow(()->new UsernameNotFoundException("usuario não encontrado"));
    }
}
