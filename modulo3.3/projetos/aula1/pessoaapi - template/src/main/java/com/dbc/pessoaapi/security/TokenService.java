package com.dbc.pessoaapi.security;


import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final UsuarioService usuarioService;

    public String getToken(LoginDTO loginDTO) {
        // FIXME por meio do usuário, gerar um token
        String tokenTexto = loginDTO.getLogin() + ";" + loginDTO.getSenha();
        return Base64.getEncoder().encodeToString(tokenTexto.getBytes());
    }

    public Optional<UsuarioEntity> isValid(String token) {
        // FIXME validar se o token é válido e retornar o usuário se for válido
        if(token == null){
            return Optional.empty();
        }
        token = token.replace("Bearer ","").trim();
        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes); // login;senha
        String[] split = decoded.split(";"); // [0] login [1] senha
        return usuarioService.pegarLoginUsuario(split[0], split[1]);
    }

}


