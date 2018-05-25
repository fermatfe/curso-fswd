package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="SALAS")

@NamedQuery (name="SalaEntidad.buscarPorCapacidad" , query="select s from SalaEntidad s where s.capacidad >= :capacidad")

public class SalaEntidad {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column ( name="SALA_ID", updatable=false)
	private Integer id;
	
	@Column (name="NOMBRE", nullable=false, length=50)
	private String nombre;
	
	@Column (name="DESCRIPCION", nullable=true, length=120)
	private String descripcion;
	
	@Column (name="CAPACIDAD", nullable=true)
    private Integer capacidad;
    
	@Column (name="LOCALIZACION", nullable=true, length=100)
    private String localizacion;
    
	@ManyToOne ( fetch=FetchType.EAGER)
	@JoinColumn(name="TIPO_ID")
    private TipoSalaEntidad tipoSala;
	
	
	@ManyToOne ( fetch=FetchType.EAGER)
	@JoinColumn(name="EDIFICIO_ID")
	private EdificioEntidad edificio;

	public SalaEntidad() { }
	
	
	public SalaEntidad(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	

	public SalaEntidad(Integer id, String nombre, String descripcion, Integer capacidad, String localizacion,
			TipoSalaEntidad tipoSala) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.localizacion = localizacion;
		this.tipoSala = tipoSala;
	}


	/* get y set */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public TipoSalaEntidad getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(TipoSalaEntidad tipoSala) {
		this.tipoSala = tipoSala;
	}
	
	


	public EdificioEntidad getEdificio() {
		return edificio;
	}


	public void setEdificio(EdificioEntidad edificio) {
		this.edificio = edificio;
	}




}
