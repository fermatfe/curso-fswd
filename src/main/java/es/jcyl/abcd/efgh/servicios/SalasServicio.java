package es.jcyl.abcd.efgh.servicios;

import java.util.List;
import java.util.Optional;

import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;

public interface SalasServicio {

	void guardar(SalaEntidad s);

	void guardar(List<SalaEntidad> s);

	void actualizar(SalaEntidad s);

	void borrar(SalaEntidad s);

	List<SalaEntidad> todos();

	Optional<SalaEntidad> buscarPorId(int id);

	List<SalaEntidad> buscarPorCapacidad(int c);

	List<SalaEntidad> buscarPorEdificio(int idEdificio);

}