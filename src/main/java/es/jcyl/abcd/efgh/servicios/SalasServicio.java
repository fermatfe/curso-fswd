package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.SalasRepositorio;

@Service
public class SalasServicio {

	
	@Autowired
	private SalasRepositorio repo;
	
	
	public void guardar ( SalaEntidad s ) {
		this.repo.save( s );
	}
	
	public void guardar ( List<SalaEntidad> s ) {
		this.repo.save( s );
	}
	
	
	public void actualizar ( SalaEntidad s ) {
		this.repo.save( s );
	}
	
	public void borrar ( SalaEntidad s) {
		this.repo.delete( s.getId() );
	}
	
	
	public List<SalaEntidad> todos() {
		return (List<SalaEntidad>) this.repo.findAll();
	}
	
	public SalaEntidad buscarPorId ( int id ) {
		return this.repo.findOne( new Integer (id));
	}
	
	public List<SalaEntidad> buscarPorCapacidad (int c) {
		return this.repo.buscarPorCapacidad( c );
	}
	
	public List<SalaEntidad> buscarPorEdificio (int idEdificio) {
		return this.repo.findByEdificioEdificioId(idEdificio);
	}
	
}
