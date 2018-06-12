package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import es.jcyl.abcd.efgh.persistencia.entidades.TipoSalaEntidad;

public interface TipoSalaServicio {

	void guardar(TipoSalaEntidad s);

	List<TipoSalaEntidad> todos();

	List<TipoSalaEntidad> buscarPorTipo(String tipo);

}