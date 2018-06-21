package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Area {
    
   
    public Integer Id;
    public String nombre;
    public Motivo Motivos; 
    
	public Integer getId() {
		return Id;
	}
	public void setid(String Id) {
		this.Id = Id;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Motivo getMotivos() {
		return Motivos;
	}
	public void setMotivo(Motivo Motivos) {
		this.Motivos = Motivos;
	}
	
}
