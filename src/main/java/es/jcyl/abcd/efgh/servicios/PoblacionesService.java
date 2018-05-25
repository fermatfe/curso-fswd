package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.PoblacionesRepositorio;

@Service
public class PoblacionesService {

	@Autowired
	PoblacionesRepositorio repo;
	
	public List<PoblacionEntidad> listar(ProvinciaEntidad provincia, String searchString) {
		return (searchString ==null) ?
				repo.findTop5ByProvinciaOrderByPoblacionAsc(provincia) :
				repo.findTop5ByProvinciaAndPoblacionStartingWithIgnoreCase(provincia, searchString);
	}
}
