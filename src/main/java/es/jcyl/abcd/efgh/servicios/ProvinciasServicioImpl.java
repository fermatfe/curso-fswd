package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ProvinciasRepositorio;

@Service
public class ProvinciasServicioImpl implements ProvinciasServicio {

	@Autowired
	ProvinciasRepositorio repo;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	public List<ProvinciaEntidad> getListado(String prov) {
		return repo.findByProvinciaStartingWithIgnoreCase(prov);
	}
}
