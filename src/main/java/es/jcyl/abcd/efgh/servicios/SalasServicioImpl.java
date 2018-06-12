package es.jcyl.abcd.efgh.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.excepciones.NotFoundException;
import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.SalasRepositorio;

@Service
public class SalasServicioImpl implements SalasServicio {

	@Autowired
	private SalasRepositorio repo;

	@Override
	public void guardar(SalaEntidad s) {
		this.repo.save(s);
	}

	@Override
	public void guardar(List<SalaEntidad> s) {
		this.repo.saveAll(s);
	}

	@Override
	public void actualizar(SalaEntidad s) {
		if (this.repo.existsById(s.getId()))
			repo.save(s);
		else
			throw new NotFoundException();
	}

	@Override
	public void borrar(SalaEntidad s) {
		this.repo.delete(s);
	}

	@Override
	public List<SalaEntidad> todos() {
		return (List<SalaEntidad>) this.repo.findAll();
	}

	@Override
	public Optional<SalaEntidad> buscarPorId(int id) {
		return this.repo.findById(id);
	}

	@Override
	public List<SalaEntidad> buscarPorCapacidad(int c) {
		return this.repo.buscarPorCapacidad(c);
	}

	@Override
	public List<SalaEntidad> buscarPorEdificio(int idEdificio) {
		return this.repo.findByEdificioEdificioId(idEdificio);
	}
}
