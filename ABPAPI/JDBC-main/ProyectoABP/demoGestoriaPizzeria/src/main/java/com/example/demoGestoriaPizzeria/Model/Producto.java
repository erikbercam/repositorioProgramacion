package com.example.demoGestoriaPizzeria.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))

    private Set<Pedido> pedidos;

    private String nombre;
    private double precio;
    private int cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}