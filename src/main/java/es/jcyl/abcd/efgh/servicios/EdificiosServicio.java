package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;
import es.jcyl.abcd.efgh.persistencia.repositorios.EdificiosRepositorio;

@Service
public class EdificiosServicio {

	@Autowired
	private EdificiosRepositorio repo;

	public void guardar(EdificioEntidad e) {
		repo.save(e);
	}

	public void actualizar(EdificioEntidad e) {
		repo.save(e);
	}

	public void borrar(EdificioEntidad e) {
		repo.delete(e);
	}

	public List<EdificioEntidad> todos() {
		return (List<EdificioEntidad>) this.repo.findAll();
	}

	public EdificioEntidad buscarPorId(Integer id) {
		return repo.getOne(id);
	}

	public List<EdificioEntidad> buscarPorNombre(String nombre) {
		return repo.findByNombreContainsIgnoreCase(nombre);
	}

	public List<EdificioEntidad> buscarPorTipoVia(TipoVia tv) {
		return repo.findByDireccionTipoVia(tv);
	}

	public List<EdificioEntidad> buscarPorProvincia(String prov) {
		return repo.buscarPorProvincia(prov);
	}

	public List<EdificioEntidad> buscar(String dir, Integer prv) {
		if (dir == null)
			return (prv == null) ? repo.findAll() : repo.findByDireccionPoblacionProvinciaProvinciaId(prv);
		else
			return (prv == null) ? repo.findByNombreContainsIgnoreCase(dir)
					: repo.findByNombreContainsIgnoreCaseAndDireccionPoblacionProvinciaProvinciaId(dir, prv);
	}

}
