package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TipoDocumento {
    
   
    public String id;
    public String nombre;

    
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
}
