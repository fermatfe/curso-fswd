package es.jcyl.abcd.efgh.persistencia.conversores;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;

@Converter
public class TipoViaConversor implements AttributeConverter <TipoVia, String>{

	@Override
	public String convertToDatabaseColumn(TipoVia attribute) {
		
		if ( attribute == null) return null;
		
		switch ( attribute ) {
		case CALLE: return "CL";
		case PASEO: return "PS";
		case AVENIDA: return "AV";
		
		default: throw new IllegalArgumentException ();
		 
		}
	}

	@Override
	public TipoVia convertToEntityAttribute(String dbData) {
		
		if (dbData == null) return null;
		
		switch ( dbData ) {
		case "CL": return TipoVia.CALLE;
		case "PS": return TipoVia.PASEO;
		case "AV": return TipoVia.AVENIDA;
		
		default: throw new IllegalArgumentException ();
		
		}
	}

}
