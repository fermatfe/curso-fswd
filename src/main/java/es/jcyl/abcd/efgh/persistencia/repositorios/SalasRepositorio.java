package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;

@Repository
public interface SalasRepositorio extends JpaRepository <SalaEntidad, Integer> {
	
	public List<SalaEntidad> buscarPorCapacidad ( @Param ("capacidad") int capacidad);

	public List<SalaEntidad> findByEdificioEdificioId ( @Param ("edificioId") Integer idEdificio );
} 
