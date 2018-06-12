package es.jcyl.abcd.efgh.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.excepciones.NotFoundException;
import es.jcyl.abcd.efgh.persistencia.entidades.ReservaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ReservasRepositorio;

@Service
public class ReservasServicioImpl implements ReservasServicio {

	@Autowired
	private ReservasRepositorio repo;

	@Override
	public List<ReservaEntidad> todos() {
		return (List<ReservaEntidad>) this.repo.findAll();
	}

	@Override
	public Optional<ReservaEntidad> buscarPorId(int id) {
		return this.repo.findById(id);
	}

	@Override
	public void guardar(ReservaEntidad r) {
		this.repo.save(r);
	}

	@Override
	public void actualizar(ReservaEntidad r) {
		if (this.repo.existsById(r.getReservaId()))
			this.repo.save(r);
		else
			throw new NotFoundException();
	}

	@Override
	public void borrar(ReservaEntidad r) {
		this.repo.delete(r);
	}
}
