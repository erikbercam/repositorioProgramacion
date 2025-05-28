//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Enums.*;
//import com.example.demoGestoriaPizzeria.Model.*;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface BebidaRepository extends JpaRepository<Bebida, Long> {
//    List<Bebida> findByTamano(TamanoBebida tamano);
//    List<Bebida> findByDisponibleTrue();
//    List<Bebida> findByNombreContainingIgnoreCase(String nombre);
//    Optional<Bebida> findByNombre(String nombre);
//
//    // Método adicional útil
//    Optional<Bebida> findByNombreAndTamano(String nombre, TamanoBebida tamano);
//    List<Bebida> findByDisponibleTrueAndCantidadGreaterThan(Integer cantidad);
//}
//
//
//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Model.Cliente;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface ClienteRepository extends JpaRepository<Cliente, Long> {
//    Optional<Cliente> findByDocumento(String documento);
//    Optional<Cliente> findByEmail(String email);
//    Optional<Cliente> findByTelefono(String telefono);
//    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
//
//    @Query("SELECT c FROM Cliente c WHERE c.pedidos IS NOT EMPTY")
//    List<Cliente> findClientesConPedidos();
//}
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Model.Combo;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ComboRepository extends JpaRepository<Combo, Long> {
//    List<Combo> findByNombreContainingIgnoreCase(String nombre);
//    List<Combo> findByPrecioBetween(double precioMin, double precioMax);
//
//    @Query("SELECT c FROM Combo c WHERE SIZE(c.productos) >= :minProductos")
//    List<Combo> findCombosConMinProductos(int minProductos);
//
//
//}
//
//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Model.Direccion;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface DireccionRepository extends JpaRepository<Direccion, Long> {
//    List<Direccion> findByCiudad(String ciudad);
//    List<Direccion> findByCodigoPostal(String codigoPostal);
//    List<Direccion> findByCiudadAndCodigoPostal(String ciudad, String codigoPostal);
//    List<Direccion> findByCalleContainingIgnoreCase(String calle);
//}
//
//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Enums.enumPuestoTrabajador;
//import com.example.demoGestoriaPizzeria.Model.Empleado;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
//    List<Empleado> findByPuesto(enumPuestoTrabajador puesto);
//    List<Empleado> findByActivoTrue();
//    List<Empleado> findByPuestoAndActivoTrue(enumPuestoTrabajador puesto, boolean activo);
//    Optional<Empleado> findByDocumento(String documento);
//    List<Empleado> findBySueldoGreaterThanEqual(double sueldo);
//
//    @Query("SELECT e FROM Empleado e WHERE e.puesto = 'REPARTIDOR' AND e.activo = true AND SIZE(e.pedidos) < :maxPedidos")
//    List<Empleado> findRepartidoresDisponibles(int maxPedidos);
//}
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Model.Ingrediente;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
//    Optional<Ingrediente> findByNombre(String nombre);
//    List<Ingrediente> findByEsVeganoTrue();
//    List<Ingrediente> findByEsIngredienteSinGlutenTrue();
//    List<Ingrediente> findByCantidadGreaterThan(int cantidad);
//    List<Ingrediente> findByCantidadLessThanEqual(int cantidad);
//    List<Ingrediente> findByNombreContainingIgnoreCase(String nombre);
//
//    @Query("SELECT i FROM Ingrediente i WHERE i.cantidad = 0")
//    List<Ingrediente> findIngredientesAgotados();
//}
//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Enums.enumEstadoPedido;
//import com.example.demoGestoriaPizzeria.Model.Cliente;
//import com.example.demoGestoriaPizzeria.Model.Empleado;
//import com.example.demoGestoriaPizzeria.Model.Pedido;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Repository
//public interface PedidoRepository extends JpaRepository<Pedido, Long> {
//    List<Pedido> findByCliente(Cliente cliente);
//    List<Pedido> findByEstado(enumEstadoPedido estado);
//    List<Pedido> findByClienteOrderByFechaPedidoDesc(Cliente cliente);
//    List<Pedido> findByRepartidor(Empleado repartidor);
//    List<Pedido> findByFechaPedidoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
//    List<Pedido> findByTotalGreaterThanEqual(Double total);
//
//    @Query("SELECT p FROM Pedido p WHERE p.fechaPedido >= :fecha AND p.estado = :estado")
//    List<Pedido> findPedidosPorFechaYEstado(@Param("fecha") LocalDateTime fecha, @Param("estado") enumEstadoPedido estado);
//
//    @Query("SELECT SUM(p.total) FROM Pedido p WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin")
//    Double calcularVentasPorPeriodo(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
//}
//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Model.Pizza;
//import com.example.demoGestoriaPizzeria.Enums.enumPizza;
//import com.example.demoGestoriaPizzeria.Enums.enumMassa;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PizzaRepository extends JpaRepository<Pizza, Long> {
//
//    List<Pizza> findByTipo(enumPizza tipo);
//
//    List<Pizza> findByEsSinGlutenTrue();
//
//    List<Pizza> findByTipoMasa(enumMassa tipoMasa);
//
//    List<Pizza> findByTipoAndTipoMasa(enumPizza tipo, enumMassa tipoMasa);
//
//    List<Pizza> findByDescripcionContainingIgnoreCase(String descripcion);
//
//    List<Pizza> findByNombreContainingIgnoreCase(String nombre); // 💡 Añadir este método si se llama desde el service
//
//    List<Pizza> findByPrecioLessThan(Double precio); // 💡 Añadir este método también si se usa desde el service
//
//    @Query("SELECT p FROM Pizza p JOIN p.ingredientes i WHERE i.nombre = :nombreIngrediente")
//    List<Pizza> findPizzasConIngrediente(String nombreIngrediente);
//
//    @Query("SELECT p FROM Pizza p WHERE p.esSinGluten = true AND " +
//            "EXISTS (SELECT i FROM p.ingredientes i WHERE i.esIngredienteSinGluten = true)")
//    List<Pizza> findPizzasCompletamenteSinGluten();
//}
//
//package com.example.demoGestoriaPizzeria.Repository;
//
//import com.example.demoGestoriaPizzeria.Model.Producto;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ProductoRepository extends JpaRepository<Producto, Long> {
//    List<Producto> findByNombreContainingIgnoreCase(String nombre);
//    List<Producto> findByPrecioBetween(double precioMin, double precioMax);
//    List<Producto> findByCantidadGreaterThan(int cantidad);
//
//    @Query("SELECT p FROM Producto p ORDER BY p.precio DESC")
//    List<Producto> findAllOrderByPrecioDesc();
//}