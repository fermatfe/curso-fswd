package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.*;

@Entity
@Table(name = "POBLACION")
public class PoblacionEntidad {
	
	@Id
	@Column ( name = "idpoblacion", updatable = false)
	private Integer poblacionId;
	
	@Column (name ="poblacion")
	private String poblacion;
	
	
	@Column( name="latitud")
	private String latitud;
	
	@Column ( name ="longitud")
	private String longitud;
	
	@ManyToOne ( fetch = FetchType.EAGER )
	@JoinColumn(name="idprovincia")
    private ProvinciaEntidad provincia;

	public PoblacionEntidad() {
		super();
	}

	public Integer getPoblacionId() {
		return poblacionId;
	}

	public void setPoblacionId(Integer poblacionId) {
		this.poblacionId = poblacionId;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public ProvinciaEntidad getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaEntidad provincia) {
		this.provincia = provincia;
	}
    
	
	
    

}
