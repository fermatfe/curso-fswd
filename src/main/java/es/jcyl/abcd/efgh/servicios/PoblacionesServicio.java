package es.jcyl.abcd.efgh.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.PoblacionesRepositorio;

@Service
public class PoblacionesServicio {
	
	@Autowired
	PoblacionesRepositorio repo;
	
	public Page<PoblacionEntidad> getPagina(Integer provinciaId, String pobl, Pageable pageable) {
		
		// Tenemos el ID de provincia, necesitamos la entidad 
		ProvinciaEntidad provincia = new ProvinciaEntidad();
		provincia.setProvinciaId(provinciaId);
		
		return repo.findByProvinciaAndPoblacionStartingWithIgnoreCase(provincia, pobl, pageable);
	}
}
