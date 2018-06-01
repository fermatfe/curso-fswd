package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ProvinciasRepositorio;

@Service
public class ProvinciasServicio {

	@Autowired
	ProvinciasRepositorio repo;
	
	public List<ProvinciaEntidad> getListado(String prov) {
		return repo.findByProvinciaStartingWithIgnoreCase(prov);
	}
}
