package com.example.demoGestoriaPizzeria.DTO;

import lombok.Data;
import java.util.List;

@Data
public class PizzaDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private List<Long> ingredientesIds;
}