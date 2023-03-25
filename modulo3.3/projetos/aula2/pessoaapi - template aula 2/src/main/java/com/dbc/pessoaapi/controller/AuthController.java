package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.dto.UsuarioDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exception.RegraDeNegocioException;
import com.dbc.pessoaapi.security.TokenService;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final TokenService tokenService;
    //FIXME injetar AuthenticationManager
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;


    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {

        //FIXME criar objeto UsernamePasswordAuthenticationToken com o usuário e senha
        UsernamePasswordAuthenticationToken userAuthDTO = new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getSenha());
        //FIXME utilizar AuthenticationManager para se autenticar
        Authentication authentication = authenticationManager.authenticate(userAuthDTO);
        //FIXME recuperar usuário após da autenticação (getPrincipal())
        Object principal = authentication.getPrincipal();
        //FIXME GERAR TOKEN (trocar null por usuarioEntity da autenticação)
        UsuarioEntity usuarioEntity = (UsuarioEntity) principal;
        return tokenService.generateToken(usuarioEntity);
    }

    @PostMapping("/criar")
    public UsuarioDTO criaUsuario(@RequestBody LoginDTO loginDTO) throws RegraDeNegocioException {
        return usuarioService.criar(loginDTO);
    }

    @GetMapping("/listarlogado")
    public UsuarioDTO listarLogado() throws RegraDeNegocioException {
        return usuarioService.getLoggedUser();
    }
}
