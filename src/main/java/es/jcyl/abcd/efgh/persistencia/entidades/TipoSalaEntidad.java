package es.jcyl.abcd.efgh.persistencia.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table ( name="TIPOS_SALAS" )
public class TipoSalaEntidad {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column ( name ="TIPO_ID", nullable = false, updatable=false)
	private Integer tipoSalaId;
	
	@Column ( name ="TIPO", nullable = false, insertable = true, updatable = true)
	private String tipo;
	
	@OneToMany (fetch=FetchType.LAZY, mappedBy="tipoSala")
	private List<SalaEntidad> salas;
	

	public TipoSalaEntidad() {
		super();
	}

	public TipoSalaEntidad(Integer tipoSalaId, String tipo) {
		super();
		this.tipoSalaId = tipoSalaId;
		this.tipo = tipo;
	}



	public Integer getTipoSalaId() {
		return tipoSalaId;
	}



	public void setTipoSalaId(Integer tipoSalaId) {
		this.tipoSalaId = tipoSalaId;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<SalaEntidad> getSalas() {
		return salas;
	}

	public void setSalas(List<SalaEntidad> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "TipoSala [tipoSalaId=" + tipoSalaId + ", tipo=" + tipo + "]";
	}
	
	
    
}
