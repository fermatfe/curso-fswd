package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.TipoSalaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.TipoSalaRepositorio;

@Service
public class TipoSalaServicioImpl implements TipoSalaServicio {

	@Autowired
	private TipoSalaRepositorio repo;

	@Override
	public void guardar(TipoSalaEntidad s) {
		this.repo.save(s);
	}

	@Override
	public List<TipoSalaEntidad> todos() {
		return (List<TipoSalaEntidad>) this.repo.findAll();
	}

	@Override
	public List<TipoSalaEntidad> buscarPorTipo(String tipo) {
		return (List<TipoSalaEntidad>) this.repo.findByTipoContainingIgnoreCase(tipo);
	}
}
