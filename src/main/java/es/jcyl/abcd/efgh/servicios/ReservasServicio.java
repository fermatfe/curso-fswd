package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.ReservaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ReservasRepositorio;

@Service
public class ReservasServicio {

	@Autowired
	private ReservasRepositorio repo;

	public List<ReservaEntidad> todos() {
		return repo.findAll();
	}

	public ReservaEntidad buscarPorId(Integer id) {
		return repo.getOne(id);
	}

	public void guardar(ReservaEntidad r) {
		repo.save(r);
	}

	public void actualizar(ReservaEntidad r) {
		repo.save(r);
	}

	public void borrar(ReservaEntidad r) {
		repo.delete(r);
	}
}