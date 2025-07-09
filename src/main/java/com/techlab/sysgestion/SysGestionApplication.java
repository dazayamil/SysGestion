package com.techlab.sysgestion;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SysGestionApplication {

	public static void main(String[] args) {
		// Cargar variables del archivo .env como si fueran del sistema
		Dotenv dotenv = Dotenv.configure().load();

		// Establecerlas como variables del sistema (opcional)
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		System.out.println("DB_URL: " + System.getProperty("DB_URL"));
		System.out.println("DB_USERNAME: " + System.getProperty("DB_USERNAME"));
		System.out.println("DB_PASSWORD: " + System.getProperty("DB_PASSWORD"));

		SpringApplication.run(SysGestionApplication.class, args);
	}

}
