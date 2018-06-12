package io.swagger.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.jcyl.abcd.efgh.excepciones.BadRequestException;
import es.jcyl.abcd.efgh.excepciones.NotFoundException;
import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;
import es.jcyl.abcd.efgh.servicios.EdificiosServicio;
import es.jcyl.abcd.efgh.servicios.SalasServicio;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Edificio;
import io.swagger.model.Sala;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

@Controller
public class EdificiosApiController implements EdificiosApi {

	@Autowired
	EdificiosServicio edificiosServicio;

	@Autowired
	SalasServicio salasServicio;

	@Autowired
	ModelMapper modelMapper;

	public ResponseEntity<Void> actualizarEdificio(
			@ApiParam(value = "ID del edificio a actualizar", required = true) @PathVariable Integer idEdificio,
			@ApiParam(value = "Nuevos Datos del edificio", required = true) @Valid @RequestBody Edificio edificio) {
		
		// Validar que el ID coincide con la URI
		if (edificio.getId() != idEdificio)
			throw new BadRequestException("El identificador del edificio es ambiguo");

		EdificioEntidad e = modelMapper.map(edificio, EdificioEntidad.class);
		edificiosServicio.actualizar(e);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Void> actualizarSala(
			@ApiParam(value = "ID del edificio a recuperar", required = true) @PathVariable Integer idEdificio,
			@ApiParam(value = "ID de la sala a actualizar", required = true) @PathVariable Integer idSala,
			@ApiParam(value = "Nuevos Datos de la sala", required = true) @Valid @RequestBody Sala sala) {
		
		// Validar que los ID coinciden en la URI
		if (sala.getId() != idSala || sala.getEdificio().getId() != idEdificio)
			throw new BadRequestException("El identificador de la sala es ambiguo");

		SalaEntidad s = modelMapper.map(sala, SalaEntidad.class);
		salasServicio.actualizar(s);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Void> agregarEdificio(
			@ApiParam(value = "Datos del nuevo edificio", required = true) @Valid @RequestBody Edificio edificio) {
		
		// Validar que no tenga ID
		if (edificio.getId() != null)
			throw new BadRequestException("El ID de edificio debe ser nulo");

		EdificioEntidad e = modelMapper.map(edificio, EdificioEntidad.class);
		edificiosServicio.guardar(e);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getEdificioId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Void> agregarSala(
			@ApiParam(value = "ID del edificio a recuperar", required = true) @PathVariable Integer idEdificio,
			@ApiParam(value = "Datos de la nueva sala") @Valid @RequestBody Sala sala) {
		
		// Validar que no tenga ID
		if (sala.getId() != null)
			throw new BadRequestException("El ID de sala debe ser nulo");

		// Validar que su edificio coincida con la URI
		if (sala.getEdificio().getId() != idEdificio)
			throw new BadRequestException("El identificador del edificio es ambiguo");

		SalaEntidad s = modelMapper.map(sala, SalaEntidad.class);
		salasServicio.guardar(s);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Void> borrarEdificio(
			@ApiParam(value = "ID del edificio a borrar", required = true) @PathVariable("idEdificio") Integer id) {
		
		// Validar existencia
		Optional<EdificioEntidad> e = edificiosServicio.buscarPorId(id);
		if (!e.isPresent())
			throw new NotFoundException("No hay edificios con ID=" + id);

		edificiosServicio.borrar(e.get());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Void> borrarSala(
			@ApiParam(value = "ID del edificio a recuperar", required = true) @PathVariable("idEdificio") Integer idEdificio,
			@ApiParam(value = "ID de la sala a borrar", required = true) @PathVariable("idSala") Integer idSala) {
		
		// Validar existencia
		Optional<SalaEntidad> s = salasServicio.buscarPorId(idSala);
		if (!s.isPresent())
			throw new NotFoundException("No hay salas con ID=" + idSala);

		// Validar que su edificio coincida con la URI
		if (s.get().getEdificio().getEdificioId() != idEdificio)
			throw new BadRequestException("El identificador del edificio es ambiguo");

		salasServicio.borrar(s.get());
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Edificio> getEdificioPorId(
			@ApiParam(value = "ID del edificio a recuperar", required = true) @PathVariable Integer idEdificio) {
		
		// Validar existencia
		Optional<EdificioEntidad> e = edificiosServicio.buscarPorId(idEdificio);
		if (!e.isPresent())
			throw new NotFoundException("No hay edificios con ID=" + idEdificio);

		Edificio edificio = modelMapper.map(e.get(), Edificio.class);
		return ResponseEntity.ok(edificio);
	}

	public ResponseEntity<List<Edificio>> getEdificios(
			@ApiParam(value = "Pasa una cadena opcional para buscar edificios") @Valid @RequestParam(value = "searchString", required = false) String busqueda,
			@ApiParam(value = "Busca los edificios de una provincia\"") @Valid @RequestParam(value = "idProvincia", required = false) Integer idProvincia) {
		
		// Validar existencia
		List<EdificioEntidad> lista = edificiosServicio.buscar(busqueda, idProvincia);
		if (lista.isEmpty())
			throw new NotFoundException("No hay edificios con esos criterios");
		
		List<Edificio> resultado = new ArrayList<Edificio>();
		for (EdificioEntidad e : lista)
			resultado.add(modelMapper.map(e, Edificio.class));

		return ResponseEntity.ok(resultado);
	}

	public ResponseEntity<Sala> getSalaPorId(
			@ApiParam(value = "ID del edificio a recuperar", required = true) @PathVariable("idEdificio") Integer idEdificio,
			@ApiParam(value = "ID de la sala a recuperar", required = true) @PathVariable("idSala") Integer idSala) {
		
		// Validar existencia
		Optional<SalaEntidad> s = salasServicio.buscarPorId(idSala);
		if (!s.isPresent())
			throw new NotFoundException("No hay salas con ID=" + idSala);

		// Validar que su edificio coincida con la URI
		if (s.get().getEdificio().getEdificioId() != idEdificio)
			throw new BadRequestException("El identificador del edificio es ambiguo");

		Sala sala = modelMapper.map(s.get(), Sala.class);
		return ResponseEntity.ok(sala);
	}

	public ResponseEntity<List<Sala>> getSalas(
			@ApiParam(value = "ID del edificio a recuperar", required = true) @PathVariable("idEdificio") Integer idEdificio) {
		
		List<SalaEntidad> lista = salasServicio.buscarPorEdificio(idEdificio);
		List<Sala> resultado = new ArrayList<Sala>();
		for (SalaEntidad s : lista)
			resultado.add(modelMapper.map(s, Sala.class));

		return ResponseEntity.ok(resultado);
	}

}
