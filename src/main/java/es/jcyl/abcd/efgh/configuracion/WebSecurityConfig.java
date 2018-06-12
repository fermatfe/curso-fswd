package es.jcyl.abcd.efgh.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] WHITELIST = {
			"/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // {noop} para password sin encriptar
		auth.inMemoryAuthentication() 
        	.withUser("user").password("{noop}user").roles("USER").and()
        	.withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().permitAll().and().httpBasic();
		http.authorizeRequests()
			.antMatchers(WHITELIST).permitAll()
			.antMatchers("/**").hasRole("USER")
			.and().httpBasic();
	}
}