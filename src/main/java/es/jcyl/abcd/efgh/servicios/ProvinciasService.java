package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ProvinciasRepositorio;

@Service
public class ProvinciasService {

	@Autowired
	ProvinciasRepositorio repo;
	
	public List<ProvinciaEntidad> listar(String searchString) {
		return (searchString ==null) ?
				(List<ProvinciaEntidad>) repo.findAll() :
				repo.findByProvinciaStartingWithIgnoreCase(searchString);
	}
	
	public List<ProvinciaEntidad> todos() {
		return (List<ProvinciaEntidad>) this.repo.findAll();
	}
}
