package br.com.alura.instalura.conf;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenerateInitialDataConfiguration {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private String SERVER_PORT;
	
	private Logger logger = LoggerFactory.getLogger(GenerateInitialDataConfiguration.class);
	
	public void generate() {
		
		URI uri = URI.create("http://localhost:" + SERVER_PORT + "/gera/dados");	
		String responseBody = restTemplate.getForObject(uri, String.class);
		
		logger.info("Gerando dados na base do instalura");
		if(!responseBody.contains("instalura"))
			logger.warn("Já existem dados na base do Instalura");
		else
			logger.info("Os dados foram gerados na base do instalura!");
	}
}
