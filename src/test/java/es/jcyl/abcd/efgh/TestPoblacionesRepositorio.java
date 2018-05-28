package es.jcyl.abcd.efgh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.PoblacionesRepositorio;
import es.jcyl.abcd.efgh.persistencia.repositorios.ProvinciasRepositorio;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ( classes = FullstackwebdevApplication.class)
public class TestPoblacionesRepositorio {
	
	@Autowired
	private PoblacionesRepositorio repo;
	
	@Autowired
	private ProvinciasRepositorio repoProv;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void testBusquedaPorPoblacion () throws Exception {
		
		Optional<ProvinciaEntidad> prov =  repoProv.findById( 40 );
		assertTrue (prov.isPresent());
		
		Sort sort = new Sort(Direction.DESC, "poblacion");
		PageRequest pageRequest = PageRequest.of(0, 5, sort);
		Page<PoblacionEntidad> pagina = repo.findByProvinciaAndPoblacionStartingWithIgnoreCase(prov.get(), "val", pageRequest);
		
		assertNotNull (pagina);
		assertEquals ( pagina.getSize() , 5);
		
		System.out.println ( "Numero de poblaciones : " + pagina.getTotalElements() );
		
		assertEquals ( pagina.getTotalElements(), 8 );
		
		assertEquals ( pagina.getContent().get(0).getPoblacion(),"Valverde de Campos");
		
		for ( PoblacionEntidad po :  pagina ) {
		    System.out.println( po.getProvincia().getProvincia() + " / " + po.getPoblacion());
		}
		
	}

}
