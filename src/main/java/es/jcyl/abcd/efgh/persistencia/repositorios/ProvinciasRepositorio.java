package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;

@Repository
public interface ProvinciasRepositorio extends SoloLecturaRepositorio <ProvinciaEntidad, Integer> {
	
	public List<ProvinciaEntidad> findByProvinciaStartingWithIgnoreCase ( @Param ("prov") String prov ); 
	
}
