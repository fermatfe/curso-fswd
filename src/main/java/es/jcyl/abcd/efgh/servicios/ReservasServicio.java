package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.ReservaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ReservasRepositorio;

@Service
public class ReservasServicio {
	
	
	@Autowired
	private ReservasRepositorio repo;
	
	
	public List<ReservaEntidad> todos() {
		return (List<ReservaEntidad>) this.repo.findAll();
	}
	
	public ReservaEntidad buscarPorId ( int id ) {
		return this.repo.findOne( new Integer (id));
	}
	
	public void guardar ( ReservaEntidad r ) {
		this.repo.save( r );
	}
	
	public void actualizar ( ReservaEntidad s ) {
		this.repo.save( s );
	}
	
	public void borrar ( ReservaEntidad s) {
		this.repo.delete( s );
	}
	

}
