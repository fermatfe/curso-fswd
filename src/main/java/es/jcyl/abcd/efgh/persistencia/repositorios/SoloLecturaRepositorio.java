package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface SoloLecturaRepositorio<T, ID extends Serializable> extends PagingAndSortingRepository <T, ID> {
	
	T findOne ( ID id );
	
	Iterable<T> findAll ();
	
	Page<T> findAll(Pageable pageable);

}
