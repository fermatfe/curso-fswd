package es.jcyl.abcd.efgh.servicios;

import java.util.List;
import java.util.Optional;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;

public interface EdificiosServicio {

	void guardar(EdificioEntidad e);

	void guardar(List<EdificioEntidad> e);

	void actualizar(EdificioEntidad e);

	void borrar(EdificioEntidad e);

	List<EdificioEntidad> todos();

	Optional<EdificioEntidad> buscarPorId(int id);

	List<EdificioEntidad> buscarPorNombre(String nombre);

	List<EdificioEntidad> buscarPorTipoVia(TipoVia tv);

	List<EdificioEntidad> buscarPorProvincia(String prov);

	List<EdificioEntidad> buscar(String dir, Integer prv);

}