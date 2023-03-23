package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TokenService {

    // FIXME RECUPERAR O TEMPO DE EXPIRAÇÃO DOS PROPERTIES
    @Value("${jwt.expiration}")
    private String expiration;

    // FIXME RECUPERAR A CHAVE SECRETA DOS PROPERTIES
    @Value("${jwt.secret}")
    private String secret;

    private final String TOKEN_PREFIX = "Bearer";

    private final UsuarioService usuarioService;

    public TokenService(@Lazy UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String generateToken(UsuarioEntity usuarioEntity) {
        // FIXME gerar token jwt
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));
        return TOKEN_PREFIX + " " +
                Jwts.builder()
                        .setIssuer("vemser-api")
                        .claim(Claims.ID,usuarioEntity.getIdUsuario().toString())
                        .setIssuedAt(now)
                        .setExpiration(exp)
                        .signWith(SignatureAlgorithm.HS256,secret)
                        .compact();
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        // FIXME verificar se o usuário é válido pelo token JWT e recuperar o usuário e retornar
        if (token != null){
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            String user = body.get(Claims.ID,String.class);
            if (user != null){
                return new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList());
            }
        }
        return null;
    }
}
