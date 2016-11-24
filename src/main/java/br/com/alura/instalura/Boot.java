package br.com.alura.instalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);		
	}
}
