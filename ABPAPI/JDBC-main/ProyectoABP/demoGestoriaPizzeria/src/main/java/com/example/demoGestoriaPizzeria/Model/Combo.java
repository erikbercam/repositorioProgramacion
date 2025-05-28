package com.example.demoGestoriaPizzeria.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Combo extends Producto {
    @ManyToMany
    @JoinTable(
            name = "combo_producto",
            joinColumns = @JoinColumn(name = "combo_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto) {
        if (productos == null) {
            productos = new ArrayList<>();
        }
        productos.add(producto);
    }
//
//    @Override
//    public double calcularPrecio() {
//        // Aplicar descuento al calcular precio del combo
//        double precioTotal = 0;
//        for (Producto producto : productos) {
//            precioTotal += producto.calcularPrecio();
//        }
//        // Aplicar un descuento del 10%
//        return precioTotal * 0.9;
//    }
}