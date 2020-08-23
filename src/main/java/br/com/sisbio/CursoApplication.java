package br.com.sisbio;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CursoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CursoApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);

    }

}
