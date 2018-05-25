package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.jcyl.abcd.efgh.persistencia.conversores.TipoViaConversor;


@Embeddable
@Access ( AccessType.FIELD )
public class DireccionEntidad {
	
	@Column (name="COD_VIA", length=2)
	@Convert (converter = TipoViaConversor.class)
	private TipoVia tipoVia;
    
    @Column (name="NOMBRE_VIA", length = 150)
    private String nombreVia;
    
    @Column (name="NUMERO_VIA", length = 10)
    private String numeroVia;
    
    @Column (name="COD_POSTAL", length =5)
    private String codigoPostal;
    
    
    @ManyToOne ( fetch = FetchType.EAGER)
    @JoinColumn (name = "ID_POBLACION")
    private PoblacionEntidad poblacion;

    
    

	public String getNombreVia() {
		return nombreVia;
	}


	public TipoVia getTipoVia() {
		return this.tipoVia;
	}


	public void setTipoVia(TipoVia tipoVia) {
		this.tipoVia = tipoVia;
	}


	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}


	public String getNumeroVia() {
		return numeroVia;
	}


	public void setNumeroVia(String numeroVia) {
		this.numeroVia = numeroVia;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public PoblacionEntidad getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(PoblacionEntidad poblacion) {
		this.poblacion = poblacion;
	}
    
    public String toString () {
    	return  this.getTipoVia() + " " + this.getNombreVia() + " " + this.getNumeroVia() + "\n" +
				this.getCodigoPostal() + " - " + this.getPoblacion().getPoblacion() + " ( " +
				this.getPoblacion().getProvincia().getProvincia() + " )";
    }

}
