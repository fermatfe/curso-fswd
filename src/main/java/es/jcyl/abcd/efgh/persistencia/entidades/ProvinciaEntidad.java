package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.*;

@Entity
@Table(name="PROVINCIA")
public class ProvinciaEntidad {
	@Id
	@Column (name="IDPROVINCIA", updatable=false, unique=true, nullable=false)
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer provinciaId;
	
	
	@Column ( name="PROVINCIA")
	private String provincia;


	public ProvinciaEntidad() {
		super();
	}


	public Integer getProvinciaId() {
		return provinciaId;
	}


	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	



}
