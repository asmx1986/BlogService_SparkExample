package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Documento {
    
   
    public Integer numero;
   
    public TipoDocumento TipoDocumentos; 
    
	public Integer getnumero() {
		return numero;
	}
	public void setnumero(Integer numero) {
		this.numero = numero;
	}
	
	
	public TipoDocumento getTipoDocumentos() {
		return TipoDocumentos;
	}
	public TipoDocumento setTipoDocumento (TipoDocumento TipoDocumento){
		
		this.TipoDocumentos = TipoDocumentos; 
		
		
	
}
}