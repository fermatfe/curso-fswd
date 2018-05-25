package es.jcyl.abcd.efgh.persistencia.entidades;

public enum TipoVia {	
	
	CALLE   ( "CL" ),
	AVENIDA ( "AV" ),
	PASEO   ( "PS" );
	
	String tipoVia;
	
	TipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	
	public String getTipoVia ( ) {
		return tipoVia;
	}
	

}
