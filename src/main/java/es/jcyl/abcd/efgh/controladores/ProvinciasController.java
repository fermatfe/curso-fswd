package es.jcyl.abcd.efgh.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.servicios.PoblacionesServicio;
import es.jcyl.abcd.efgh.servicios.ProvinciasServicio;

@RestController
public class ProvinciasController {

	@Autowired
	ProvinciasServicio provinciasServicio;
	
	@Autowired
	PoblacionesServicio poblacionesServicio;
	
	@GetMapping("/provincias")
	public List<ProvinciaEntidad> getProvincias(
			@RequestParam(value="searchString", defaultValue="") String prov) {

		return provinciasServicio.getListado(prov);
	}
	
	@GetMapping("/provincias/{id}/poblaciones")
	public ResponseEntity<List<PoblacionEntidad>> getPoblaciones(
			@PathVariable("id") Integer provinciaId,
			@RequestParam(value="searchString", required=true) String pobl,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<PoblacionEntidad> pagina = poblacionesServicio.getPagina(provinciaId, pobl, pageable);
		return ResponseEntity.ok(pagina.getContent());
	}
}
