package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EDIFICIOS")
public class EdificioEntidad {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column (name = "EDIFICIO_ID", updatable=false)
	private Integer edificioId;
	
	@Column (name="NOMBRE" , nullable = false)
    private String nombre;
    
	@Column (name="TITULARIDAD" , nullable = true)
    private String titularidad;
	
	@Embedded
    private DireccionEntidad direccion;
	

	public EdificioEntidad() {
		super();
	}

	public EdificioEntidad(Integer edificioId, String nombre, String titularidad, DireccionEntidad direccion) {
		super();
		this.edificioId = edificioId;
		this.nombre = nombre;
		this.titularidad = titularidad;
		this.direccion = direccion;
	}

	public Integer getEdificioId() {
		return edificioId;
	}

	public void setEdificioId(Integer edificioId) {
		this.edificioId = edificioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitularidad() {
		return titularidad;
	}

	public void setTitularidad(String titularidad) {
		this.titularidad = titularidad;
	}

	public DireccionEntidad getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionEntidad direccion) {
		this.direccion = direccion;
	}
}
