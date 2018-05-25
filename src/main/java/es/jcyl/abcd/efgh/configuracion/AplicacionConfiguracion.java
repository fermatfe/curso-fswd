package es.jcyl.abcd.efgh.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("es.jcyl.abcd.efgh.persistencia")
@EnableTransactionManagement
public class AplicacionConfiguracion {

}
