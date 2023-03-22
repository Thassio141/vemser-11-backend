package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // FIXME recuperar token do header
        // FIXME recuperar usuário do token
        // FIXME adicionar o usuário no contexto do spring security
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        Optional<UsuarioEntity> validToken = tokenService.isValid(token);
        if (validToken.isPresent()){
            Authentication authentication = new UsernamePasswordAuthenticationToken(validToken.get(), (Object)null, (Collection)null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else {
            SecurityContextHolder.getContext().setAuthentication((Authentication)null);
        }

        filterChain.doFilter(request, response);
    }
}
