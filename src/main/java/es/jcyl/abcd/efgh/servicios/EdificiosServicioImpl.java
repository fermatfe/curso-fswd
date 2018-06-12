package es.jcyl.abcd.efgh.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.excepciones.NotFoundException;
import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;
import es.jcyl.abcd.efgh.persistencia.repositorios.EdificiosRepositorio;

@Service
public class EdificiosServicioImpl implements EdificiosServicio {

	@Autowired
	private EdificiosRepositorio repo;

	@Override
	public void guardar(EdificioEntidad e) {
		this.repo.save(e);
	}

	@Override
	public void guardar(List<EdificioEntidad> e) {
		this.repo.saveAll(e);
	}

	@Override
	public void actualizar(EdificioEntidad e) {
		if (this.repo.existsById(e.getEdificioId()))
			this.repo.save(e);
		else
			throw new NotFoundException();
	}

	@Override
	public void borrar(EdificioEntidad e) {
		this.repo.delete(e);
	}

	@Override
	public List<EdificioEntidad> todos() {
		return (List<EdificioEntidad>) this.repo.findAll();
	}

	@Override
	public Optional<EdificioEntidad> buscarPorId(int id) {
		return this.repo.findById(id);
	}

	@Override
	public List<EdificioEntidad> buscarPorNombre(String nombre) {
		return this.repo.findByNombreContainsIgnoreCase(nombre);
	}

	@Override
	public List<EdificioEntidad> buscarPorTipoVia(TipoVia tv) {
		return this.repo.findByDireccionTipoVia(tv);
	}

	@Override
	public List<EdificioEntidad> buscarPorProvincia(String prov) {
		return this.repo.buscarPorProvincia(prov);
	}

	@Override
	public List<EdificioEntidad> buscar(String dir, Integer prv) {
		if (dir == null)
			return (prv == null) ? repo.findAll() : repo.findByDireccionPoblacionProvinciaProvinciaId(prv);
		else
			return (prv == null) ? repo.findByNombreContainsIgnoreCase(dir)
					: repo.findByNombreContainsIgnoreCaseAndDireccionPoblacionProvinciaProvinciaId(dir, prv);
	}

}
