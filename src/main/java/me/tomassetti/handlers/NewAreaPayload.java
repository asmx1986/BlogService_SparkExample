package me.tomassetti.handlers;

import java.util.List;
import lombok.Data;
import me.tomassetti.Validable;
import me.tomassetti.model.Motivo;

@Data
class NewAreaPayload implements Validable {

    private String nombre;
    private List <Motivo> motivos;

    public boolean isValid() {
        return getNombre() != null && !getNombre().isEmpty();
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