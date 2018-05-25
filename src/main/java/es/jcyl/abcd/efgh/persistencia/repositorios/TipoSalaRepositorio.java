package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.TipoSalaEntidad;

@Repository
public interface TipoSalaRepositorio extends SoloLecturaRepositorio <TipoSalaEntidad, Integer> {
	
	public List<TipoSalaEntidad> findByTipo (String n);
	
	public List<TipoSalaEntidad> findByTipoContainingIgnoreCase (String n);

}
