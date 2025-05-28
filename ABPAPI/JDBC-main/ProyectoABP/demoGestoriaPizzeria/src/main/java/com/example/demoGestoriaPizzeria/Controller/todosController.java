//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Enums.enumEstadoPedido;
//import com.example.demoGestoriaPizzeria.Enums.enumMassa;
//import com.example.demoGestoriaPizzeria.Enums.enumPizza;
//import com.example.demoGestoriaPizzeria.Enums.enumPuestoTrabajador;
//import com.example.demoGestoriaPizzeria.Model.*;
//import com.example.demoGestoriaPizzeria.Services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//public class todosController {
//}
////package com.example.demoGestoriaPizzeria.Controller;
//
////import com.example.demoGestoriaPizzeria.Model.Cliente;
////import com.example.demoGestoriaPizzeria.Services.ClienteService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////@RequestMapping("/api/clientes")
////public class ClienteController {
////
////    @Autowired
////    private ClienteService clienteService;
////
////    @GetMapping
////    public List<Cliente> obtenerTodosLosClientes() {
////        return clienteService.obtenerTodosLosClientes();
////    }
////
////    @GetMapping("/{id}")
////    public Cliente obtenerClientePorId(@PathVariable Long id) {
////        return clienteService.obtenerClientePorId(id);
////    }
////
////    @PostMapping
////    public Cliente crearCliente(@RequestBody Cliente cliente) {
////        return clienteService.crearCliente(cliente);
////    }
////
////    @PutMapping("/{id}")
////    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
////        return clienteService.actualizarCliente(id, cliente);
////    }
////
////    @DeleteMapping("/{id}")
////    public void eliminarCliente(@PathVariable Long id) {
////        clienteService.eliminarCliente(id);
////    }
////
////    @GetMapping("/buscar")
////    public List<Cliente> buscarClientesPorNombre(@RequestParam String nombre) {
////        return clienteService.buscarClientesPorNombre(nombre);
////    }
////}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Model.Cliente;
//import com.example.demoGestoriaPizzeria.Services.ClienteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/clientes")
//@CrossOrigin(origins = "*")
//public class ClienteController {
//
//    @Autowired
//    private ClienteService clienteService;
//
//    @GetMapping
//    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
//        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
//        return ResponseEntity.ok(clientes);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
//        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
//        return cliente.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
//        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
//        try {
//            Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
//            return ResponseEntity.ok(clienteActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
//        clienteService.eliminarCliente(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/documento/{documento}")
//    public ResponseEntity<Cliente> buscarPorDocumento(@PathVariable String documento) {
//        Optional<Cliente> cliente = clienteService.buscarPorDocumento(documento);
//        return cliente.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/email/{email}")
//    public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email) {
//        Optional<Cliente> cliente = clienteService.buscarPorEmail(email);
//        return cliente.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/telefono/{telefono}")
//    public ResponseEntity<Cliente> buscarPorTelefono(@PathVariable String telefono) {
//        Optional<Cliente> cliente = clienteService.buscarPorTelefono(telefono);
//        return cliente.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/buscar")
//    public ResponseEntity<List<Cliente>> buscarClientesPorNombre(@RequestParam String nombre) {
//        List<Cliente> clientes = clienteService.buscarClientesPorNombre(nombre);
//        return ResponseEntity.ok(clientes);
//    }
//
//    @GetMapping("/con-pedidos")
//    public ResponseEntity<List<Cliente>> obtenerClientesConPedidos() {
//        List<Cliente> clientes = clienteService.obtenerClientesConPedidos();
//        return ResponseEntity.ok(clientes);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Model.Combo;
//import com.example.demoGestoriaPizzeria.Services.ComboService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/combos")
//@CrossOrigin(origins = "*")
//public class ComboController {
//
//    @Autowired
//    private ComboService comboService;
//
//    @GetMapping
//    public ResponseEntity<List<Combo>> obtenerTodosLosCombos() {
//        List<Combo> combos = comboService.obtenerTodosLosCombos();
//        return ResponseEntity.ok(combos);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Combo> obtenerComboPorId(@PathVariable Long id) {
//        Optional<Combo> combo = comboService.obtenerComboPorId(id);
//        return combo.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Combo> crearCombo(@RequestBody Combo combo) {
//        Combo nuevoCombo = comboService.guardarCombo(combo);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCombo);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Combo> actualizarCombo(@PathVariable Long id, @RequestBody Combo combo) {
//        try {
//            Combo comboActualizado = comboService.actualizarCombo(id, combo);
//            return ResponseEntity.ok(comboActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarCombo(@PathVariable Long id) {
//        comboService.eliminarCombo(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("/{comboId}/productos/{productoId}")
//    public ResponseEntity<Combo> agregarProductoACombo(@PathVariable Long comboId, @PathVariable Long productoId) {
//        try {
//            Combo combo = comboService.agregarProductoACombo(comboId, productoId);
//            return ResponseEntity.ok(combo);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{comboId}/productos/{productoId}")
//    public ResponseEntity<Combo> quitarProductoDeCombo(@PathVariable Long comboId, @PathVariable Long productoId) {
//        try {
//            Combo combo = comboService.quitarProductoDeCombo(comboId, productoId);
//            return ResponseEntity.ok(combo);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/buscar")
//    public ResponseEntity<List<Combo>> buscarCombosPorNombre(@RequestParam String nombre) {
//        List<Combo> combos = comboService.buscarCombosPorNombre(nombre);
//        return ResponseEntity.ok(combos);
//    }
//
//    @GetMapping("/precio")
//    public ResponseEntity<List<Combo>> buscarCombosPorRangoPrecio(@RequestParam double min, @RequestParam double max) {
//        List<Combo> combos = comboService.buscarCombosPorRangoPrecio(min, max);
//        return ResponseEntity.ok(combos);
//    }
//
//    @GetMapping("/minimos-productos")
//    public ResponseEntity<List<Combo>> buscarCombosConMinProductos(@RequestParam int minProductos) {
//        List<Combo> combos = comboService.buscarCombosConMinProductos(minProductos);
//        return ResponseEntity.ok(combos);
//    }
//}
//
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Model.Complemento;
//import com.example.demoGestoriaPizzeria.Services.ComplementoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/complementos")
//@CrossOrigin(origins = "*")
//public class ComplementoController {
//
//    @Autowired
//    private ComplementoService complementoService;
//
//    @GetMapping
//    public ResponseEntity<List<Complemento>> obtenerTodosLosComplementos() {
//        List<Complemento> complementos = complementoService.obtenerTodosLosComplementos();
//        return ResponseEntity.ok(complementos);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Complemento> obtenerComplementoPorId(@PathVariable Long id) {
//        Optional<Complemento> complemento = complementoService.obtenerComplementoPorId(id);
//        return complemento.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Complemento> crearComplemento(@RequestBody Complemento complemento) {
//        Complemento nuevoComplemento = complementoService.guardarComplemento(complemento);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComplemento);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Complemento> actualizarComplemento(@PathVariable Long id, @RequestBody Complemento complemento) {
//        try {
//            Complemento complementoActualizado = complementoService.actualizarComplemento(id, complemento);
//            return ResponseEntity.ok(complementoActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarComplemento(@PathVariable Long id) {
//        complementoService.eliminarComplemento(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/tipo/{tipo}")
//    public ResponseEntity<List<Complemento>> obtenerComplementosPorTipo(@PathVariable String tipo) {
//        List<Complemento> complementos = complementoService.obtenerComplementosPorTipo(tipo);
//        return ResponseEntity.ok(complementos);
//    }
//
//    @GetMapping("/disponibles")
//    public ResponseEntity<List<Complemento>> obtenerComplementosDisponibles() {
//        List<Complemento> complementos = complementoService.obtenerComplementosDisponibles();
//        return ResponseEntity.ok(complementos);
//    }
//
//    @GetMapping("/sin-gluten")
//    public ResponseEntity<List<Complemento>> obtenerComplementosSinGluten() {
//        List<Complemento> complementos = complementoService.obtenerComplementosSinGluten();
//        return ResponseEntity.ok(complementos);
//    }
//
//    @GetMapping("/buscar")
//    public ResponseEntity<List<Complemento>> buscarComplementosPorNombre(@RequestParam String nombre) {
//        List<Complemento> complementos = complementoService.buscarComplementosPorNombre(nombre);
//        return ResponseEntity.ok(complementos);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Model.Direccion;
//import com.example.demoGestoriaPizzeria.Services.DireccionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/direcciones")
//@CrossOrigin(origins = "*")
//public class DireccionController {
//
//    @Autowired
//    private DireccionService direccionService;
//
//    @GetMapping
//    public ResponseEntity<List<Direccion>> obtenerTodasLasDirecciones() {
//        List<Direccion> direcciones = direccionService.obtenerTodasLasDirecciones();
//        return ResponseEntity.ok(direcciones);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Direccion> obtenerDireccionPorId(@PathVariable Long id) {
//        Optional<Direccion> direccion = direccionService.obtenerDireccionPorId(id);
//        return direccion.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Direccion> crearDireccion(@RequestBody Direccion direccion) {
//        Direccion nuevaDireccion = direccionService.guardarDireccion(direccion);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDireccion);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Direccion> actualizarDireccion(@PathVariable Long id, @RequestBody Direccion direccion) {
//        try {
//            Direccion direccionActualizada = direccionService.actualizarDireccion(id, direccion);
//            return ResponseEntity.ok(direccionActualizada);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarDireccion(@PathVariable Long id) {
//        direccionService.eliminarDireccion(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/ciudad/{ciudad}")
//    public ResponseEntity<List<Direccion>> buscarDireccionesPorCiudad(@PathVariable String ciudad) {
//        List<Direccion> direcciones = direccionService.buscarDireccionesPorCiudad(ciudad);
//        return ResponseEntity.ok(direcciones);
//    }
//
//    @GetMapping("/codigo-postal/{codigoPostal}")
//    public ResponseEntity<List<Direccion>> buscarDireccionesPorCodigoPostal(@PathVariable String codigoPostal) {
//        List<Direccion> direcciones = direccionService.buscarDireccionesPorCodigoPostal(codigoPostal);
//        return ResponseEntity.ok(direcciones);
//    }
//
//    @GetMapping("/buscar-calle")
//    public ResponseEntity<List<Direccion>> buscarDireccionesPorCalle(@RequestParam String calle) {
//        List<Direccion> direcciones = direccionService.buscarDireccionesPorCalle(calle);
//        return ResponseEntity.ok(direcciones);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Enums.enumPuestoTrabajador;
//import com.example.demoGestoriaPizzeria.Model.Empleado;
//import com.example.demoGestoriaPizzeria.Services.EmpleadoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/empleados")
//@CrossOrigin(origins = "*")
//public class EmpleadoController {
//
//    @Autowired
//    private EmpleadoService empleadoService;
//
//    @GetMapping
//    public ResponseEntity<List<Empleado>> obtenerTodosLosEmpleados() {
//        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
//        return ResponseEntity.ok(empleados);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
//        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorId(id);
//        return empleado.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
//        Empleado nuevoEmpleado = empleadoService.guardarEmpleado(empleado);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
//        try {
//            Empleado empleadoActualizado = empleadoService.actualizarEmpleado(id, empleado);
//            return ResponseEntity.ok(empleadoActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
//        empleadoService.eliminarEmpleado(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}/desactivar")
//    public ResponseEntity<Void> desactivarEmpleado(@PathVariable Long id) {
//        empleadoService.desactivarEmpleado(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/puesto/{puesto}")
//    public ResponseEntity<List<Empleado>> obtenerEmpleadosPorPuesto(@PathVariable enumPuestoTrabajador puesto) {
//        List<Empleado> empleados = empleadoService.obtenerEmpleadosPorPuesto(puesto);
//        return ResponseEntity.ok(empleados);
//    }
//
//    @GetMapping("/activos")
//    public ResponseEntity<List<Empleado>> obtenerEmpleadosActivos() {
//        List<Empleado> empleados = empleadoService.obtenerEmpleadosActivos();
//        return ResponseEntity.ok(empleados);
//    }
//
//    @GetMapping("/documento/{documento}")
//    public ResponseEntity<Empleado> buscarPorDocumento(@PathVariable String documento) {
//        Optional<Empleado> empleado = empleadoService.buscarPorDocumento(documento);
//        return empleado.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/sueldo-minimo")
//    public ResponseEntity<List<Empleado>> obtenerEmpleadosPorSueldoMinimo(@RequestParam double sueldo) {
//        List<Empleado> empleados = empleadoService.obtenerEmpleadosPorSueldoMinimo(sueldo);
//        return ResponseEntity.ok(empleados);
//    }
//
//    @GetMapping("/repartidores-disponibles")
//    public ResponseEntity<List<Empleado>> obtenerRepartidoresDisponibles(@RequestParam int maxPedidos) {
//        List<Empleado> repartidores = empleadoService.obtenerRepartidoresDisponibles(maxPedidos);
//        return ResponseEntity.ok(repartidores);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Model.Ingrediente;
//import com.example.demoGestoriaPizzeria.Services.IngredienteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/ingredientes")
//@CrossOrigin(origins = "*")
//public class IngredienteController {
//
//    @Autowired
//    private IngredienteService ingredienteService;
//
//    @GetMapping
//    public ResponseEntity<List<Ingrediente>> obtenerTodosLosIngredientes() {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerTodosLosIngredientes();
//        return ResponseEntity.ok(ingredientes);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Ingrediente> obtenerIngredientePorId(@PathVariable Long id) {
//        Optional<Ingrediente> ingrediente = ingredienteService.obtenerIngredientePorId(id);
//        return ingrediente.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Ingrediente> crearIngrediente(@RequestBody Ingrediente ingrediente) {
//        Ingrediente nuevoIngrediente = ingredienteService.guardarIngrediente(ingrediente);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoIngrediente);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Ingrediente> actualizarIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
//        try {
//            Ingrediente ingredienteActualizado = ingredienteService.actualizarIngrediente(id, ingrediente);
//            return ResponseEntity.ok(ingredienteActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarIngrediente(@PathVariable Long id) {
//        ingredienteService.eliminarIngrediente(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/sin-gluten")
//    public ResponseEntity<List<Ingrediente>> obtenerIngredientesSinGluten() {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesSinGluten();
//        return ResponseEntity.ok(ingredientes);
//    }
//
//    @GetMapping("/veganos")
//    public ResponseEntity<List<Ingrediente>> obtenerIngredientesVeganos() {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesVeganos();
//        return ResponseEntity.ok(ingredientes);
//    }
//
//    @PutMapping("/{id}/stock")
//    public ResponseEntity<Void> actualizarStockIngrediente(@PathVariable Long id, @RequestParam int cantidad) {
//        ingredienteService.actualizarStockIngrediente(id, cantidad);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/buscar")
//    public ResponseEntity<List<Ingrediente>> obtenerIngredientesPorNombre(@RequestParam String nombre) {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesPorNombre(nombre);
//        return ResponseEntity.ok(ingredientes);
//    }
//
//    @GetMapping("/con-stock")
//    public ResponseEntity<List<Ingrediente>> obtenerIngredientesConStock(@RequestParam int cantidadMinima) {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesConStock(cantidadMinima);
//        return ResponseEntity.ok(ingredientes);
//    }
//
//    @GetMapping("/poco-stock")
//    public ResponseEntity<List<Ingrediente>> obtenerIngredientesConPocoStock(@RequestParam int cantidadMaxima) {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesConPocoStock(cantidadMaxima);
//        return ResponseEntity.ok(ingredientes);
//    }
//
//    @GetMapping("/agotados")
//    public ResponseEntity<List<Ingrediente>> obtenerIngredientesAgotados() {
//        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesAgotados();
//        return ResponseEntity.ok(ingredientes);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Enums.enumEstadoPedido;
//import com.example.demoGestoriaPizzeria.Model.Cliente;
//import com.example.demoGestoriaPizzeria.Model.Empleado;
//import com.example.demoGestoriaPizzeria.Model.Pedido;
//import com.example.demoGestoriaPizzeria.Services.PedidoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/pedidos")
//@CrossOrigin(origins = "*")
//public class PedidoController {
//
//    @Autowired
//    private PedidoService pedidoService;
//
//    // Obtener todos los pedidos
//    @GetMapping
//    public ResponseEntity<List<Pedido>> obtenerTodosLosPedidos() {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedido por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
//        try {
//            Optional<Pedido> pedido = pedidoService.obtenerPedidoPorId(id);
//            return pedido.map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.notFound().build());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Crear nuevo pedido
//    @PostMapping
//    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
//        try {
//            Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
//            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Actualizar pedido
//    @PutMapping("/{id}")
//    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
//        try {
//            Pedido pedidoActualizado = pedidoService.actualizarPedido(id, pedido);
//            return ResponseEntity.ok(pedidoActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Eliminar pedido
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
//        try {
//            pedidoService.eliminarPedido(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por estado
//    @GetMapping("/estado/{estado}")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorEstado(@PathVariable enumEstadoPedido estado) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorEstado(estado);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Cambiar estado del pedido
//    @PatchMapping("/{id}/estado")
//    public ResponseEntity<Pedido> cambiarEstadoPedido(@PathVariable Long id, @RequestBody enumEstadoPedido nuevoEstado) {
//        try {
//            Pedido pedidoActualizado = pedidoService.cambiarEstadoPedido(id, nuevoEstado);
//            return ResponseEntity.ok(pedidoActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Asignar repartidor a pedido
//    @PatchMapping("/{pedidoId}/repartidor/{repartidorId}")
//    public ResponseEntity<Pedido> asignarRepartidor(@PathVariable Long pedidoId, @PathVariable Long repartidorId) {
//        try {
//            Pedido pedidoActualizado = pedidoService.asignarRepartidor(pedidoId, repartidorId);
//            return ResponseEntity.ok(pedidoActualizado);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por cliente
//    @PostMapping("/cliente")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorCliente(@RequestBody Cliente cliente) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorCliente(cliente);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por cliente ordenados por fecha
//    @PostMapping("/cliente/ordenados")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorClienteOrdenados(@RequestBody Cliente cliente) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorClienteOrdenados(cliente);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por repartidor
//    @PostMapping("/repartidor")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorRepartidor(@RequestBody Empleado repartidor) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorRepartidor(repartidor);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por rango de fechas
//    @GetMapping("/rango-fecha")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorRangoFecha(
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorRangoFecha(fechaInicio, fechaFin);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por monto mínimo
//    @GetMapping("/monto-minimo/{montoMinimo}")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorMontoMinimo(@PathVariable Double montoMinimo) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorMontoMinimo(montoMinimo);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pedidos por fecha y estado
//    @GetMapping("/fecha-estado")
//    public ResponseEntity<List<Pedido>> obtenerPedidosPorFechaYEstado(
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
//            @RequestParam enumEstadoPedido estado) {
//        try {
//            List<Pedido> pedidos = pedidoService.obtenerPedidosPorFechaYEstado(fecha, estado);
//            return ResponseEntity.ok(pedidos);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Calcular ventas por período
//    @GetMapping("/ventas-periodo")
//    public ResponseEntity<Double> calcularVentasPorPeriodo(
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
//        try {
//            Double ventas = pedidoService.calcularVentasPorPeriodo(fechaInicio, fechaFin);
//            return ResponseEntity.ok(ventas != null ? ventas : 0.0);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Controller;
//
//import com.example.demoGestoriaPizzeria.Enums.enumMassa;
//import com.example.demoGestoriaPizzeria.Enums.enumPizza;
//import com.example.demoGestoriaPizzeria.Model.Pizza;
//import com.example.demoGestoriaPizzeria.Services.PizzaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/pizzas")
//@CrossOrigin(origins = "*")
//public class PizzaController {
//
//    @Autowired
//    private PizzaService pizzaService;
//
//    // Obtener todas las pizzas
//    @GetMapping
//    public ResponseEntity<List<Pizza>> obtenerTodasLasPizzas() {
//        try {
//            List<Pizza> pizzas = pizzaService.obtenerTodasLasPizzas();
//            return ResponseEntity.ok(pizzas);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pizza por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Pizza> obtenerPizzaPorId(@PathVariable Long id) {
//        try {
//            Optional<Pizza> pizza = pizzaService.obtenerPizzaPorId(id);
//            return pizza.map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.notFound().build());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Crear nueva pizza
//    @PostMapping
//    public ResponseEntity<Pizza> crearPizza(@RequestBody Pizza pizza) {
//        try {
//            Pizza nuevaPizza = pizzaService.guardarPizza(pizza);
//            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPizza);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Actualizar pizza
//    @PutMapping("/{id}")
//    public ResponseEntity<Pizza> actualizarPizza(@PathVariable Long id, @RequestBody Pizza pizza) {
//        try {
//            Pizza pizzaActualizada = pizzaService.actualizarPizza(id, pizza);
//            return ResponseEntity.ok(pizzaActualizada);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Eliminar pizza
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarPizza(@PathVariable Long id) {
//        try {
//            pizzaService.eliminarPizza(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Buscar pizzas por tipo
//    @GetMapping("/tipo/{tipo}")
//    public ResponseEntity<List<Pizza>> buscarPizzasPorTipo(@PathVariable enumPizza tipo) {
//        try {
//            List<Pizza> pizzas = pizzaService.buscarPizzasPorTipo(tipo);
//            return ResponseEntity.ok(pizzas);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Buscar pizzas por tipo de masa
//    @GetMapping("/masa/{tipoMasa}")
//    public ResponseEntity<List<Pizza>> buscarPizzasPorTipoMasa(@PathVariable enumMassa tipoMasa) {
//        try {
//            List<Pizza> pizzas = pizzaService.buscarPizzasPorTipoMasa(tipoMasa);
//            return ResponseEntity.ok(pizzas);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Buscar pizzas por nombre
//    @GetMapping("/buscar")
//    public ResponseEntity<List<Pizza>> buscarPizzasPorNombre(@RequestParam String nombre) {
//        try {
//            List<Pizza> pizzas = pizzaService.buscarPizzasPorNombre(nombre);
//            return ResponseEntity.ok(pizzas);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Obtener pizzas sin gluten
//    @GetMapping("/sin-gluten")
//    public ResponseEntity<List<Pizza>> buscarPizzasSinGluten() {
//        try {
//            List<Pizza> pizzas = pizzaService.buscarPizzasSinGluten();
//            return ResponseEntity.ok(pizzas);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    // Buscar pizzas por precio menor que
//    @GetMapping("/precio-menor/{precio}")
//    public ResponseEntity<List<Pizza>> buscarPizzasPorPrecioMenorQue(@PathVariable Double precio) {
//        try {
//            List<Pizza> pizzas = pizzaService.buscarPizzasPorPrecioMenorQue(precio);
//            return ResponseEntity.ok(pizzas);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}