package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ProvinciasRepositorio;

@Service
public class ProvinciasServicioImpl implements ProvinciasServicio {

	@Autowired
	ProvinciasRepositorio repo;
	
	/* (non-Javadoc)
	 * @see es.jcyl.abcd.efgh.servicios.IProvinciasServicio#getListado(java.lang.String)
	 */
	@Override
	public List<ProvinciaEntidad> getListado(String prov) {
		return repo.findByProvinciaStartingWithIgnoreCase(prov);
	}
}
