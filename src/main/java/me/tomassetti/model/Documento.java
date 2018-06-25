package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Documento {
    
   
    private Integer numero;
   
    private TipoDocumento TipoDocumentos; 
    
	private Integer getnumero() {
		return numero;
	}
	public void setnumero(Integer numero) {
		this.numero = numero;
	}
	
	
	public TipoDocumento getTipoDocumentos() {
		return TipoDocumentos;
	}
	
	public void setTipoDocumento (TipoDocumento TipoDocumento){
		
		this.TipoDocumentos = TipoDocumentos; 
		
		
	
}
}