package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;

@Repository
public interface EdificiosRepositorio extends JpaRepository <EdificioEntidad, Integer> {
	
	public List<EdificioEntidad> findByNombreContainsIgnoreCase (@Param ("nombre")String nombre);
	
	public List<EdificioEntidad> findByDireccionTipoVia ( @Param ("tipoVia") TipoVia tipoVia );
	
	public List<EdificioEntidad> findByDireccionPoblacionProvinciaProvinciaId ( @Param ("provinciaId") Integer provinciaId );
	
	public List<EdificioEntidad> findByNombreContainsIgnoreCaseAndDireccionPoblacionProvinciaProvinciaId ( @Param ("nombre")String nombre, @Param ("provinciaId") Integer provinciaId );
	
	@Query ("select edif "
			+ "from EdificioEntidad edif "
			+ "left join edif.direccion.poblacion pob left join pob.provincia prov "
			+ "where upper(prov.provincia) like concat ('%',concat(upper(:prov),'%'))")
	public List<EdificioEntidad> buscarPorProvincia ( @Param ("prov") String prov );
}
