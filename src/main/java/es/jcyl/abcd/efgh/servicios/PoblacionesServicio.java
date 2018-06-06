package es.jcyl.abcd.efgh.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;

public interface PoblacionesServicio {

	public Page<PoblacionEntidad> getPagina(Integer provinciaId, String pobl, Pageable pageable);

}