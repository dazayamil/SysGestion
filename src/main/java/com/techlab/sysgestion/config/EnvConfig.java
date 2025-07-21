package com.techlab.sysgestion.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    // Cargar variables del archivo .env como si fueran del sistema
    @Bean
    public Dotenv dotenv(){
        return Dotenv.configure().load();
    }

}
