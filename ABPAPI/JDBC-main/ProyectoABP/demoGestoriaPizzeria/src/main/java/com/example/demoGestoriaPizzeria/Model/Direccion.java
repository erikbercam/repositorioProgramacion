//package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//public class Direccion {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String calle;
//    private String numero;
//    private String ciudad;
//    private String codigoPostal;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cliente_id")
//    private Cliente cliente;
//}

package com.example.demoGestoriaPizzeria.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String numero;
    private String ciudad;
    private String codigoPostal;

    @OneToOne(mappedBy = "direccion")
    private Persona persona;
}