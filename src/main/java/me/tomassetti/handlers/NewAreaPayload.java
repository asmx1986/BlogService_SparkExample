package me.tomassetti.handlers;

import lombok.Data;
import me.tomassetti.Validable;
import me.tomassetti.model.Area;

@Data
public class NewAreaPayload extends Area implements Validable {
    public boolean isValid() {
        return getNombre() != null && !getNombre().isEmpty();
        		//&& getMotivos() != null && getMotivos().size() > 0;
    }
}