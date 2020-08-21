package com.curso2020.curso;

import com.curso2020.curso.telas.TelaLogin2;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CursoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CursoApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);

    }
//Criação do Bean
    @Bean
    public TelaLogin2 frame() {
        return new TelaLogin2();
    }

}
