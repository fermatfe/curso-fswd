package io.swagger.api;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.jcyl.abcd.efgh.excepciones.BadRequestException;
import es.jcyl.abcd.efgh.excepciones.NotFoundException;
import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.servicios.PoblacionesServicio;
import es.jcyl.abcd.efgh.servicios.ProvinciasServicio;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Poblacion;
import io.swagger.model.Provincia;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T19:55:47.984Z")

@Controller
public class ProvinciasApiController implements ProvinciasApi {

	final ProvinciasServicio provinciasSrv;
	final PoblacionesServicio poblacionesSrv;
	final ModelMapper modelMapper;

	public ProvinciasApiController(	ProvinciasServicio provinciasSrv, 
									PoblacionesServicio poblacionesSrv,
									ModelMapper modelMapper ) {
		
		this.provinciasSrv = provinciasSrv;
		this.poblacionesSrv = poblacionesSrv;
		this.modelMapper = modelMapper;
	}

	public ResponseEntity<List<Poblacion>> getPoblaciones(
			@ApiParam(value = "ID de la provincia para recuperar sus poblaciones", required = true) @PathVariable Integer idProvincia,
			@ApiParam(value = "Pasa una cadena opcional para buscar poblaciones") @Valid @RequestParam(value = "searchString", required = false) String busqueda,
			@Min(0) @ApiParam(value = "Numero de pagina solicitada (desde 0)", defaultValue = "0") @Valid @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@Min(0) @Max(50) @ApiParam(value = "Numero registros por pagina", defaultValue = "5") @Valid @RequestParam(value = "size", required = false, defaultValue = "5") Integer size) {

		Page<PoblacionEntidad> pagina = poblacionesSrv.getPagina(idProvincia, busqueda, PageRequest.of(page, size));

		if (pagina.getTotalElements() == 0)
			throw new NotFoundException("No hay poblaciones que comiencen por " + busqueda);

		if (pagina.getNumberOfElements() == 0)
			throw new BadRequestException("Pagina inexistente");

		Type tipo = new TypeToken<List<Poblacion>>() {}.getType();
		List<Poblacion> resultado = modelMapper.map(pagina.getContent(), tipo);

		return ResponseEntity.ok(resultado);
	}

	public ResponseEntity<List<Provincia>> getProvincias(
			@ApiParam(value = "Pasa una cadena opcional para buscar provincias", defaultValue = "") @Valid @RequestParam(value = "searchString", required = false, defaultValue = "") String busqueda) {

		List<ProvinciaEntidad> lista = provinciasSrv.getListado(busqueda);

		if (lista.isEmpty())
			throw new NotFoundException("No hay provincias que comiencen por " + busqueda);

		Type tipo = new TypeToken<List<Provincia>>() {}.getType();
		List<Provincia> resultado = modelMapper.map(lista, tipo);

		return ResponseEntity.ok(resultado);
	}

}
