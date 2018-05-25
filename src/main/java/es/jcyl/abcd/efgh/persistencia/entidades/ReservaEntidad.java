package es.jcyl.abcd.efgh.persistencia.entidades;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table (name="RESERVAS")
public class ReservaEntidad {
	
	
	@Id
	@GeneratedValue ( strategy=GenerationType.IDENTITY )
	@Column ( name = "RESERVA_ID", updatable = false, insertable = false)
	private Integer reservaId;
	
	@ManyToOne ( fetch = FetchType.EAGER)
	@JoinColumn (name="SALA_ID")
	private SalaEntidad sala;
	
	@Temporal(value = TemporalType.DATE )
	@Column ( name = "FEC_RESERVA" , nullable=false)
	private Date fechaReserva;
	
	@Column ( name ="USUARIO", length=15, nullable=false)
	private String usuario;

	
	
	public ReservaEntidad() {
		super();
	}

	public Integer getReservaId() {
		return reservaId;
	}

	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}

	public SalaEntidad getSala() {
		return sala;
	}

	public void setSala(SalaEntidad sala) {
		this.sala = sala;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Reserva [reservaId=" + reservaId + ", sala=" + sala + ", fechaReserva=" + fechaReserva + ", usuario="
				+ usuario + "]";
	}
	
	
 
}
