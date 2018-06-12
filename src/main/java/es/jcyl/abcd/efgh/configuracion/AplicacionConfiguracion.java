package es.jcyl.abcd.efgh.configuracion;

import java.util.Date;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;

@Configuration
@ComponentScan ("io.swagger")
public class AplicacionConfiguracion {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "PUT", "POST", "DELETE")
						.maxAge(3600);
			}
		};
	}
	
	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
		
        Converter<Date, LocalDate> toLocalDate = new Converter<Date, LocalDate>() {
			public LocalDate convert(MappingContext<Date, LocalDate> context) {
				LocalDate localDate = null;
				Date date = context.getSource();
				if (date != null) {
					Instant instant = Instant.ofEpochMilli(date.getTime());
					ZoneId zone = ZoneId.systemDefault();
					localDate = instant.atZone(zone).toLocalDate();
				}
				return localDate;
			 }
		};
		
		modelMapper.addConverter(toLocalDate);
		
		Converter<LocalDate, Date> toDate = new Converter<LocalDate, Date>() {
			public Date convert(MappingContext<LocalDate, Date> context) {
				Date date = null;
				LocalDate localDate = context.getSource();
				if (localDate != null) {
					ZoneId zone = ZoneId.systemDefault();
					Instant instant = localDate.atStartOfDay(zone).toInstant();
					date = new Date(instant.toEpochMilli());
				}
				return date;
			 }
		};
		
		modelMapper.addConverter(toDate);
		
		return modelMapper;
    }
	
}
