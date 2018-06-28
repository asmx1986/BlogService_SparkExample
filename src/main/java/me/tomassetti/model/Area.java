package me.tomassetti.model;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class Area {
    private UUID uuid;
    private String nombre;
    private List<Motivo> motivos; 
    
	public UUID getUuid() {
		return uuid;
	}
	
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Motivo> getMotivos() {
		return motivos;
	}
	
	public void setMotivos(List<Motivo> motivos) {
		this.motivos = motivos;
	}
}
