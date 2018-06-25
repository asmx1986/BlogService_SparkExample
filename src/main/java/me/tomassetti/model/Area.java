package me.tomassetti.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Area {
    
   
    public String Id;
    public String Nombre;
    public List <Motivo> Motivos; 
    
	public String getId() {
		return Id;
	}
	public void setid(String Id) {
		this.Id = Id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	
	public List<Motivo> getMotivos() {
		return Motivos;
	}
	public void setMotivo(List<Motivo> Motivos) {
		this.Motivos = Motivos;
	}
	
}
