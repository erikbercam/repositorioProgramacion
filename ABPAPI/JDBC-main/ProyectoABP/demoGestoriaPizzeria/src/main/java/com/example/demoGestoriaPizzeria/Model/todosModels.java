//package com.example.demoGestoriaPizzeria.Model;
//
//import com.example.demoGestoriaPizzeria.Enums.*;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//public class todosModels {
//}
//package com.example.demoGestoriaPizzeria.Model;
//import com.example.demoGestoriaPizzeria.Enums.TamanoBebida;
//import com.example.demoGestoriaPizzeria.Model.Producto;
//import jakarta.persistence.*;
//        import lombok.Data;
//import lombok.EqualsAndHashCode;
//@Entity
//@Data
//@EqualsAndHashCode(callSuper = true)
//public class Bebida extends Producto {
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private TamanoBebida tamano;
//
//    @Column(nullable = false)
//    private boolean disponible = true;
//
//    // Constructor vacío requerido por JPA
//    public Bebida() {}
//
//    // Constructor con parámetros
//    public Bebida(String nombre, Double precio, TamanoBebida tamano) {
//        this.setNombre(nombre);
//        this.setPrecio(precio);
//        this.tamano = tamano;
//        this.disponible = true;
//        this.setCantidad(0);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//        import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Cliente extends Persona{
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Pedido> pedidos;
//}
//
//package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//        import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@EqualsAndHashCode(callSuper = true)
//public class Combo extends Producto {
//    @ManyToMany
//    @JoinTable(
//            name = "combo_producto",
//            joinColumns = @JoinColumn(name = "combo_id"),
//            inverseJoinColumns = @JoinColumn(name = "producto_id"))
//    private List<Producto> productos = new ArrayList<>();
//
//    public void addProducto(Producto producto) {
//        if (productos == null) {
//            productos = new ArrayList<>();
//        }
//        productos.add(producto);
//    }
//
//
//    package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//    @Entity
//    @Data
//    @EqualsAndHashCode(callSuper = true)
//    public class Complemento extends Producto {
//        //    private String nombre; // "ENSALADA", "POSTRE"
//        private String tipo;
//        private boolean disponible;
//        private boolean essinGluten;
//package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//        @Entity
//        @Data
//        @EqualsAndHashCode(callSuper = true)
//        public class Complemento extends Producto {
//            //    private String nombre; // "ENSALADA", "POSTRE"
//            private String tipo;
//            private boolean disponible;
//            private boolean essinGluten;
//
//
//
//
//package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//            @Entity
//            @Data
//            public class Direccion {
//                @Id
//                @GeneratedValue(strategy = GenerationType.IDENTITY)
//                private Long id;
//
//                private String calle;
//                private String numero;
//                private String ciudad;
//                private String codigoPostal;
//
//                @OneToOne(mappedBy = "direccion")
//                private Persona persona;
//            }
//
//
//            package com.example.demoGestoriaPizzeria.Model;
//
//import com.example.demoGestoriaPizzeria.Enums.enumPuestoTrabajador;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//            @Entity
//            @Data
//            @AllArgsConstructor
//            @NoArgsConstructor
//            public class Empleado extends Persona{
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//                @Enumerated(EnumType.STRING)
//                private enumPuestoTrabajador puesto;
//
//                private double sueldo;
//                private boolean activo;
//
//                @OneToMany(mappedBy = "repartidor", cascade = CascadeType.ALL, orphanRemoval = true)
//                private List<Pedido> pedidos;
//
//                public void asignarPedido(Pedido pedido) {
//                    if (pedidos == null) {
//                        pedidos = new ArrayList<>();
//                    }
//                    pedidos.add(pedido);
//                    pedido.setRepartidor(this);
//                }
//
//                public List<Pedido> getPedidosAsignados() {
//                    return pedidos;
//                }
//
//                public String getPuesto() {
//                    return puesto.toString();
//                }
//            }
//
//            package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//            @AllArgsConstructor
//            @NoArgsConstructor
//            @Entity
//            @Data
//            public class Ingrediente {
//                @Id
//                @GeneratedValue(strategy = GenerationType.IDENTITY)
//                private Long id;
//
//                private String nombre;
//                private int cantidad;
//                private boolean esVegano;
//                private boolean esIngredienteSinGluten;
//
//                @ManyToMany(mappedBy = "ingredientes")
//                private Set<Pizza> pizzas;
//            }
//package com.example.demoGestoriaPizzeria.Model;
//
//import com.example.demoGestoriaPizzeria.Enums.enumEstadoPedido;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//            @Entity
//            @Data
//            @AllArgsConstructor
//            @NoArgsConstructor
//            public class Pedido {
//
//                @Id
//                @GeneratedValue(strategy = GenerationType.IDENTITY)
//                private Long idPedido;
//
//                private LocalDateTime fechaPedido;
//                private Double total;
//                @Enumerated(EnumType.STRING)
//                private enumEstadoPedido estado;
//
//                @ManyToOne
//                @JoinColumn(name = "cliente_id")
//                private Cliente cliente;
//
//                @ManyToOne
//                @JoinColumn(name = "empleado_id")
//                private com.example.demoGestoriaPizzeria.Model.Empleado repartidor;
//
//                private double precio;
//
//                @ManyToMany(mappedBy = "pedidos")
//                private Set<Producto> productos;
//            }
//
//
//
//            package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//            @Entity
//            @Data
//            @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//            public abstract class Persona {
//                @Id
//                @GeneratedValue(strategy = GenerationType.AUTO)
//                private Long id;
//
//                private String nombre;
//                private String documento;
//                private String email;
//                private String telefono;
//
//                @OneToOne(cascade = CascadeType.ALL)
//                @JoinColumn(name = "direccion_id")
//                private com.example.demoGestoriaPizzeria.Model.Direccion direccion;
//            }
//
//
//            package com.example.demoGestoriaPizzeria.Model;
//
//import com.example.demoGestoriaPizzeria.Enums.enumMassa;
//import com.example.demoGestoriaPizzeria.Enums.enumPizza;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//            @AllArgsConstructor
//            @NoArgsConstructor
//            @Entity
//            @Data
//            public class Pizza extends Producto {
//                //    private Long id;
//                @Enumerated(EnumType.STRING)
//                private enumPizza tipo;
//
//                private String descripcion;
//
//                @Enumerated(EnumType.STRING)
//                private enumMassa tipoMasa;
//                private boolean esSinGluten;
//
//                @ManyToMany
//                @JoinTable(
//                        name = "pizza_ingrediente",
//                        joinColumns = @JoinColumn(name = "pizza_id"),
//                        inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
//                private Set<com.example.demoGestoriaPizzeria.Model.Ingrediente> ingredientes;
//            }
//
//
//
//            package com.example.demoGestoriaPizzeria.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Set;
//
//            @Entity
//            @Data
//            @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//            public abstract class Producto {
//                @Id
//                @GeneratedValue(strategy = GenerationType.AUTO)
//                private Long id;
//                @ManyToMany
//                @JoinTable(
//                        name = "pedido_producto",
//                        joinColumns = @JoinColumn(name = "producto_id"),
//                        inverseJoinColumns = @JoinColumn(name = "pedido_id"))
//
//                private Set<com.example.demoGestoriaPizzeria.Model.Pedido> pedidos;
//
//                private String nombre;
//                private double precio;
//                private int cantidad;
//
//                public Long getId() {
//                    return id;
//                }
//
//                public void setId(Long id) {
//                    this.id = id;
//                }
//
//                public Set<com.example.demoGestoriaPizzeria.Model.Pedido> getPedidos() {
//                    return pedidos;
//                }
//
//                public void setPedidos(Set<com.example.demoGestoriaPizzeria.Model.Pedido> pedidos) {
//                    this.pedidos = pedidos;
//                }
//
//                public String getNombre() {
//                    return nombre;
//                }
//
//                public void setNombre(String nombre) {
//                    this.nombre = nombre;
//                }
//
//                public double getPrecio() {
//                    return precio;
//                }
//
//                public void setPrecio(double precio) {
//                    this.precio = precio;
//                }
//
//                public int getCantidad() {
//                    return cantidad;
//                }
//
//                public void setCantidad(int cantidad) {
//                    this.cantidad = cantidad;
//                }
//            }