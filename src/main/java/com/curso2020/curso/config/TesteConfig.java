package com.curso2020.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso2020.curso.entidades.Usuario;
import com.curso2020.curso.repositorios.UsuarioRepositorio;
import com.curso2020.curso.telas.TelaLogin2;
import javax.swing.UIManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TesteConfig.class.getName());

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private TelaLogin2 frame;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inicializando o banco com os dados de teste ...");

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", passwordEncoder.encode("123456"), "adm");
        logger.info("Inserindo usuário de teste: {}", u1);

        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", passwordEncoder.encode("123456"), "adm");
        logger.info("Inserindo usuário de teste: {}", u2);

        usuarioRepositorio.saveAll(Arrays.asList(u1, u2));

        /* display the form using the AWT EventQueue */
        javax.swing.SwingUtilities.invokeLater(() -> {
            configuraLookAndFeel();
            frame.setVisible(true);
        });
    }

    private void configuraLookAndFeel() {
        try {
            // configura a aplicação para utilizar o visual do sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.error("Erro inesperado ao configurar visual da interface: {}", ex.getMessage());
        }
    }
}
