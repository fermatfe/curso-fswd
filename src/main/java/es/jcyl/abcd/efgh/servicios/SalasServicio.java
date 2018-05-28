package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.SalasRepositorio;

@Service
public class SalasServicio {

	@Autowired
	private SalasRepositorio repo;

	public void guardar(SalaEntidad s) {
		repo.save(s);
	}

	public void actualizar(SalaEntidad s) {
		repo.save(s);
	}

	public void borrar(SalaEntidad s) {
		repo.delete(s);
	}

	public List<SalaEntidad> todos() {
		return repo.findAll();
	}

	public SalaEntidad buscarPorId(Integer id) {
		return repo.getOne(id);
	}

	public List<SalaEntidad> buscarPorCapacidad(int c) {
		return repo.buscarPorCapacidad(c);
	}

	public List<SalaEntidad> buscarPorEdificio(int idEdificio) {
		return repo.findByEdificioEdificioId(idEdificio);
	}

}
