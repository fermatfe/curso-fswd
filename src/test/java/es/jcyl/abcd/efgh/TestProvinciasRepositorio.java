package es.jcyl.abcd.efgh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.ProvinciasRepositorio;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ( classes = FullstackwebdevApplication.class)
public class TestProvinciasRepositorio {
	
	@Autowired
	private ProvinciasRepositorio repo;
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Test
	public void testBusquedasPorNombre () throws Exception {
		
		List<ProvinciaEntidad> provincias = repo.findByProvinciaStartingWithIgnoreCase ("vall");
		assertNotNull ( provincias);
		assertEquals ( 1, provincias.size() );
		
	}
}
