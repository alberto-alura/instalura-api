package br.com.alura.instalura;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.alura.instalura.conf.GenerateInitialDataConfiguration;

import br.com.alura.instalura.models.Usuario;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
<<<<<<< HEAD
=======
@Controller
@EnableSwagger2
>>>>>>> work
public class Boot {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Boot.class, args);
		context.getBean(GenerateInitialDataConfiguration.class).generate();
	}
	
<<<<<<< HEAD
=======
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		//jogando a ordem lá para baixo, tem que rodar do filtro do security.
		bean.setOrder(-100000);
		return bean;
	}	
	
	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("/")
				.ignoredParameterTypes(Usuario.class)
				.globalOperationParameters(Arrays.asList(new ParameterBuilder().name("X-AUTH-TOKEN")
						.description("Description of header").modelRef(new ModelRef("string"))
						.parameterType("header").required(false).build()));
	}	
>>>>>>> work
}
