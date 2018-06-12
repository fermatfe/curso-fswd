package es.jcyl.abcd.efgh.servicios;

import java.util.List;
import java.util.Optional;

import es.jcyl.abcd.efgh.persistencia.entidades.ReservaEntidad;

public interface ReservasServicio {

	List<ReservaEntidad> todos();

	Optional<ReservaEntidad> buscarPorId(int id);

	void guardar(ReservaEntidad r);

	void actualizar(ReservaEntidad s);

	void borrar(ReservaEntidad s);

}