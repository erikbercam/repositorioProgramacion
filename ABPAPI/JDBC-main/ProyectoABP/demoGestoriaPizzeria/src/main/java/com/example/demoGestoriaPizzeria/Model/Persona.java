package com.example.demoGestoriaPizzeria.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String documento;
    private String email;
    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
}