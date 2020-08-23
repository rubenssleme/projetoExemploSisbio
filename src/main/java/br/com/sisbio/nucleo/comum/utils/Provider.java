package br.com.sisbio.nucleo.comum.utils;

import br.com.sisbio.cadastramento.api.service.UsuarioServico;
import br.com.sisbio.tela.TelaLogin2;
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
