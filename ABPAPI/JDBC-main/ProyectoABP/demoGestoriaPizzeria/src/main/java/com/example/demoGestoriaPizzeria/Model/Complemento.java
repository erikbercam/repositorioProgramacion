package com.example.demoGestoriaPizzeria.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Complemento extends Producto {
//    private String nombre; // "ENSALADA", "POSTRE"
    private String tipo;
    private boolean disponible;
    private boolean essinGluten;

//    public String mostrarDetalle() {
//        String glutenInfo = essinGluten ? "Sin gluten" : "Con gluten";
//        return "Complemento: " + nombre + ", " + glutenInfo + ", Precio: " + calcularPrecio();
//    }
}