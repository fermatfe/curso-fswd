package es.jcyl.abcd.efgh.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Fecha de reserva no disponible")
public class ConflictException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
