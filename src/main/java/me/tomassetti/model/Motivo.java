package me.tomassetti.model;

import java.util.List;
import java.util.UUID;

public class Motivo {
    private UUID uuid;
    private String nombre;
    
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

}
