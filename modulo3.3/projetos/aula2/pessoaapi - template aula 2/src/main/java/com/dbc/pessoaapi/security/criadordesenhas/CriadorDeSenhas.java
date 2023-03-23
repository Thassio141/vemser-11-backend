package com.dbc.pessoaapi.security.criadordesenhas;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);

        String senhaCriptografada = "$2a$10$BEQIJJtljzEOlP3UcvFmHutpUsobhWCfUAl/jvlqLvtuXFHfQ.MV6";
        boolean matches = bCryptPasswordEncoder.matches("123",senhaCriptografada);
        System.out.println(matches);
    }
}
