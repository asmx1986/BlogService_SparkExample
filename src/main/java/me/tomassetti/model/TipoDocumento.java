package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TipoDocumento {
    
   
    public Integer id;
    public String nombre;

    
	public Integer getid() {
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
