package com.curso2020.curso.utils;

import com.curso2020.curso.servicos.UsuarioServico;
import com.curso2020.curso.telas.TelaLogin2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Provider {

    @Autowired
    private UsuarioServico usuarioServico;

    @Bean
    public TelaLogin2 frame() {
        return new TelaLogin2(usuarioServico);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
