package br.com.alura.instalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.alura.instalura.conf.GenerateInitialDataConfiguration;

@SpringBootApplication
public class Boot {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Boot.class, args);
		context.getBean(GenerateInitialDataConfiguration.class).generate();
	}
	
}
