package io.swagger.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.jcyl.abcd.efgh.excepciones.ConflictException;
import es.jcyl.abcd.efgh.excepciones.NotFoundException;
import es.jcyl.abcd.efgh.persistencia.entidades.ReservaEntidad;
import es.jcyl.abcd.efgh.servicios.ReservasServicio;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Reserva;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

@Controller
public class ReservasApiController implements ReservasApi {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ReservasServicio reservasServicio;

	public ResponseEntity<Void> actualizarReserva(
			@ApiParam(value = "ID de la reserva a actualizar", required = true) @PathVariable("idReserva") Integer idReserva,
			@ApiParam(value = "Nuevos Datos de la reserva", required = true) @Valid @RequestBody Reserva reserva) {
		
		// Validar que el ID coincide con la URI
		if (reserva.getId() != idReserva)
			throw new NotFoundException("El identificador de la reserva es ambiguo");
		
		ReservaEntidad r = modelMapper.map(reserva, ReservaEntidad.class);
		
		reservasServicio.actualizar(r);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Void> agregarReserva(
			@ApiParam(value = "Datos de la nueva reserva", required = true) @Valid @RequestBody Reserva reserva) {
		
		ReservaEntidad r = modelMapper.map(reserva, ReservaEntidad.class);
		try {
			reservasServicio.guardar(r);
		} catch (DataIntegrityViolationException e) {
			throw new ConflictException();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(r.getReservaId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Void> borrarReservaPorID(
			@ApiParam(value = "ID de la reserva a borrar", required = true) @PathVariable("idReserva") Integer idReserva) {
		
		Optional<ReservaEntidad> r = reservasServicio.buscarPorId(idReserva);
		if (!r.isPresent())
			throw new NotFoundException("No hay reservas con ID=" + idReserva);

		reservasServicio.borrar(r.get());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Reserva> getReservaPorId(
			@ApiParam(value = "ID de la reserva a recuperar", required = true) @PathVariable Integer idReserva) {
		
		// Verificar existencia
		Optional<ReservaEntidad> r = reservasServicio.buscarPorId(idReserva);
		if (!r.isPresent())
			throw new NotFoundException("No hay reservas con ID=" + idReserva);

		Reserva reserva = modelMapper.map(r.get(), Reserva.class);
		
		return ResponseEntity.ok(reserva);
	}

	public ResponseEntity<List<Reserva>> getReservas() {
		List<Reserva> resultado = new ArrayList<Reserva>();
		for (ReservaEntidad r : reservasServicio.todos())
			resultado.add(modelMapper.map(r, Reserva.class));
		return ResponseEntity.ok(resultado);
	}
}