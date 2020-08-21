package com.curso2020.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso2020.curso.entidades.Usuario;
import com.curso2020.curso.repositorios.UsuarioRepositorio;
import com.curso2020.curso.telas.TelaLogin2;
import org.springframework.stereotype.Component;


@Configuration
@Component
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
     @Autowired
    private TelaLogin2 frame;
    
            
    
    @Override
    public void run(String... args) throws Exception {
       
        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", "adm");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456", "adm");
        usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
        
        /* display the form using the AWT EventQueue */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}
