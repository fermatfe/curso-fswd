package es.jcyl.abcd.efgh.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaRepositories("es.jcyl.abcd.efgh.persistencia")
@EnableTransactionManagement
public class AplicacionConfiguracion {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/v1/**")
						.allowedOrigins("*")
						.allowedMethods("GET")
						.maxAge(3600);
			}
		};
	}
	
}
