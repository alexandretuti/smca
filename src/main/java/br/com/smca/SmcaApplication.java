package br.com.smca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SmcaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SmcaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
