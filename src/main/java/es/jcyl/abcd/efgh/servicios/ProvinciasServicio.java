package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;

public interface ProvinciasServicio {

	public List<ProvinciaEntidad> getListado(String prov);

}