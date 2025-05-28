//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Enums.*;
//import com.example.demoGestoriaPizzeria.Model.*;
//import com.example.demoGestoriaPizzeria.Repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//public class servicesenteros {
//}
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Enums.TamanoBebida;
//import com.example.demoGestoriaPizzeria.Model.Bebida;
//import com.example.demoGestoriaPizzeria.Repository.BebidaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BebidaService {
//
//    private final BebidaRepository bebidaRepository;
//
//    @Autowired
//    public BebidaService(BebidaRepository bebidaRepository) {
//        this.bebidaRepository = bebidaRepository;
//    }
//
//    public List<Bebida> obtenerTodasLasBebidas() {
//        return bebidaRepository.findAll();
//    }
//
//    public Optional<Bebida> obtenerBebidaPorId(Long id) {
//        return bebidaRepository.findById(id);
//    }
//
//    public Bebida guardarBebida(Bebida bebida) {
//        // Validación: evitar duplicados
//        Optional<Bebida> existente = bebidaRepository
//                .findByNombreAndTamano(bebida.getNombre(), bebida.getTamano());
//
//        if (existente.isPresent()) {
//            throw new RuntimeException("Ya existe una bebida con el mismo nombre y tamaño");
//        }
//
//        return bebidaRepository.save(bebida);
//    }
//
//    public Bebida actualizarBebida(Long id, Bebida bebidaActualizada) {
//        return bebidaRepository.findById(id)
//                .map(bebidaExistente -> {
//                    bebidaExistente.setNombre(bebidaActualizada.getNombre());
//                    bebidaExistente.setPrecio(bebidaActualizada.getPrecio());
//                    bebidaExistente.setCantidad(bebidaActualizada.getCantidad());
//                    bebidaExistente.setTamano(bebidaActualizada.getTamano());
//                    bebidaExistente.setDisponible(bebidaActualizada.isDisponible());
//                    return bebidaRepository.save(bebidaExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Bebida no encontrada con id: " + id));
//    }
//
//    public void eliminarBebida(Long id) {
//        if (!bebidaRepository.existsById(id)) {
//            throw new RuntimeException("Bebida no encontrada con id: " + id);
//        }
//        bebidaRepository.deleteById(id);
//    }
//
//    public List<Bebida> obtenerBebidasPorTamano(TamanoBebida tamano) {
//        return bebidaRepository.findByTamano(tamano);
//    }
//
//    public List<Bebida> obtenerBebidasDisponibles() {
//        return bebidaRepository.findByDisponibleTrue();
//    }
//
//    // Método mejorado: solo bebidas disponibles con stock
//    public List<Bebida> obtenerBebidasEnStock() {
//        return bebidaRepository.findByDisponibleTrueAndCantidadGreaterThan(0);
//    }
//
//    public List<Bebida> buscarBebidasPorNombre(String nombre) {
//        return bebidaRepository.findByNombreContainingIgnoreCase(nombre);
//    }
//
//    public Optional<Bebida> buscarBebidaPorNombre(String nombre) {
//        return bebidaRepository.findByNombre(nombre);
//    }
//
//    // Método adicional útil
//    public boolean hayStock(Long id, Integer cantidadRequerida) {
//        return bebidaRepository.findById(id)
//                .map(bebida -> bebida.isDisponible() && bebida.getCantidad() >= cantidadRequerida)
//                .orElse(false);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Model.Cliente;
//import com.example.demoGestoriaPizzeria.Repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClienteService {
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    public List<Cliente> obtenerTodosLosClientes() {
//        return clienteRepository.findAll();
//    }
//
//    public Optional<Cliente> obtenerClientePorId(Long id) {
//        return clienteRepository.findById(id);
//    }
//
//    public Cliente guardarCliente(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }
//
//    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
//        return clienteRepository.findById(id)
//                .map(clienteExistente -> {
//                    clienteExistente.setNombre(clienteActualizado.getNombre());
//                    clienteExistente.setDocumento(clienteActualizado.getDocumento());
//                    clienteExistente.setEmail(clienteActualizado.getEmail());
//                    clienteExistente.setTelefono(clienteActualizado.getTelefono());
//                    clienteExistente.setDireccion(clienteActualizado.getDireccion());
//                    return clienteRepository.save(clienteExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
//    }
//
//    public void eliminarCliente(Long id) {
//        clienteRepository.deleteById(id);
//    }
//
//    public Optional<Cliente> buscarPorDocumento(String documento) {
//        return clienteRepository.findByDocumento(documento);
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public Optional<Cliente> buscarPorEmail(String email) {
//        return clienteRepository.findByEmail(email);
//    }
//
//    public Optional<Cliente> buscarPorTelefono(String telefono) {
//        return clienteRepository.findByTelefono(telefono);
//    }
//
//    public List<Cliente> buscarClientesPorNombre(String nombre) {
//        return clienteRepository.findByNombreContainingIgnoreCase(nombre);
//    }
//
//    public List<Cliente> obtenerClientesConPedidos() {
//        return clienteRepository.findClientesConPedidos();
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Model.Combo;
//import com.example.demoGestoriaPizzeria.Model.Producto;
//import com.example.demoGestoriaPizzeria.Repository.ComboRepository;
//import com.example.demoGestoriaPizzeria.Repository.ProductoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class ComboService {
//
//    @Autowired
//    private ComboRepository comboRepository;
//
//    @Autowired
//    private ProductoRepository productoRepository;
//
//    public List<Combo> obtenerTodosLosCombos() {
//        return comboRepository.findAll();
//    }
//
//    public Optional<Combo> obtenerComboPorId(Long id) {
//        return comboRepository.findById(id);
//    }
//
//    public Combo guardarCombo(Combo combo) {
//        return comboRepository.save(combo);
//    }
//
//    public Combo actualizarCombo(Long id, Combo comboActualizado) {
//        return comboRepository.findById(id)
//                .map(comboExistente -> {
//                    comboExistente.setNombre(comboActualizado.getNombre());
//                    comboExistente.setPrecio(comboActualizado.getPrecio());
//                    comboExistente.setCantidad(comboActualizado.getCantidad());
//                    comboExistente.setProductos(comboActualizado.getProductos());
//                    return comboRepository.save(comboExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Combo no encontrado con id: " + id));
//    }
//
//    public void eliminarCombo(Long id) {
//        comboRepository.deleteById(id);
//    }
//
//    public Combo agregarProductoACombo(Long comboId, Long productoId) {
//        return comboRepository.findById(comboId)
//                .map(combo -> {
//                    Optional<Producto> producto = productoRepository.findById(productoId);
//                    if (producto.isPresent()) {
//                        combo.addProducto(producto.get());
//                        return comboRepository.save(combo);
//                    }
//                    throw new RuntimeException("Producto no encontrado con id: " + productoId);
//                })
//                .orElseThrow(() -> new RuntimeException("Combo no encontrado con id: " + comboId));
//    }
//
//    public Combo quitarProductoDeCombo(Long comboId, Long productoId) {
//        return comboRepository.findById(comboId)
//                .map(combo -> {
//                    combo.getProductos().removeIf(p -> p.getId().equals(productoId));
//                    return comboRepository.save(combo);
//                })
//                .orElseThrow(() -> new RuntimeException("Combo no encontrado con id: " + comboId));
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public List<Combo> buscarCombosPorNombre(String nombre) {
//        return comboRepository.findByNombreContainingIgnoreCase(nombre);
//    }
//
//    public List<Combo> buscarCombosPorRangoPrecio(double precioMin, double precioMax) {
//        return comboRepository.findByPrecioBetween(precioMin, precioMax);
//    }
//
//    public List<Combo> buscarCombosConMinProductos(int minProductos) {
//        return comboRepository.findCombosConMinProductos(minProductos);
//    }
//}
//
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Model.Complemento;
//import com.example.demoGestoriaPizzeria.Repository.ComplementoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ComplementoService {
//
//    @Autowired
//    private ComplementoRepository complementoRepository;
//
//    public List<Complemento> obtenerTodosLosComplementos() {
//        return complementoRepository.findAll();
//    }
//
//    public Optional<Complemento> obtenerComplementoPorId(Long id) {
//        return complementoRepository.findById(id);
//    }
//
//    public Complemento guardarComplemento(Complemento complemento) {
//        return complementoRepository.save(complemento);
//    }
//
//    public Complemento actualizarComplemento(Long id, Complemento complementoActualizado) {
//        return complementoRepository.findById(id)
//                .map(complementoExistente -> {
//                    complementoExistente.setNombre(complementoActualizado.getNombre());
//                    complementoExistente.setPrecio(complementoActualizado.getPrecio());
//                    complementoExistente.setCantidad(complementoActualizado.getCantidad());
//                    complementoExistente.setTipo(complementoActualizado.getTipo());
//                    complementoExistente.setDisponible(complementoActualizado.isDisponible());
//                    complementoExistente.setEssinGluten(complementoActualizado.isEssinGluten());
//                    return complementoRepository.save(complementoExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Complemento no encontrado con id: " + id));
//    }
//
//    public void eliminarComplemento(Long id) {
//        complementoRepository.deleteById(id);
//    }
//
//    public List<Complemento> obtenerComplementosPorTipo(String tipo) {
//        return complementoRepository.findByTipo(tipo);
//    }
//
//    public List<Complemento> obtenerComplementosDisponibles() {
//        return complementoRepository.findByDisponibleTrue();
//    }
//
//    public List<Complemento> obtenerComplementosSinGluten() {
//        return complementoRepository.findByEssinGlutenTrue();
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public List<Complemento> obtenerComplementosPorTipoYDisponibilidad(String tipo, boolean disponible) {
//        return complementoRepository.findByTipoAndDisponibleTrue(tipo, disponible);
//    }
//
//    public List<Complemento> buscarComplementosPorNombre(String nombre) {
//        return complementoRepository.findByNombreContainingIgnoreCase(nombre);
//    }
//}
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Model.Direccion;
//import com.example.demoGestoriaPizzeria.Repository.DireccionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DireccionService {
//
//    @Autowired
//    private DireccionRepository direccionRepository;
//
//    public List<Direccion> obtenerTodasLasDirecciones() {
//        return direccionRepository.findAll();
//    }
//
//    public Optional<Direccion> obtenerDireccionPorId(Long id) {
//        return direccionRepository.findById(id);
//    }
//
//    public Direccion guardarDireccion(Direccion direccion) {
//        return direccionRepository.save(direccion);
//    }
//
//    public Direccion actualizarDireccion(Long id, Direccion direccionActualizada) {
//        return direccionRepository.findById(id)
//                .map(direccionExistente -> {
//                    direccionExistente.setCalle(direccionActualizada.getCalle());
//                    direccionExistente.setNumero(direccionActualizada.getNumero());
//                    direccionExistente.setCiudad(direccionActualizada.getCiudad());
//                    direccionExistente.setCodigoPostal(direccionActualizada.getCodigoPostal());
//                    return direccionRepository.save(direccionExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Dirección no encontrada con id: " + id));
//    }
//
//    public void eliminarDireccion(Long id) {
//        direccionRepository.deleteById(id);
//    }
//
//    public List<Direccion> buscarDireccionesPorCiudad(String ciudad) {
//        return direccionRepository.findByCiudad(ciudad);
//    }
//
//    public List<Direccion> buscarDireccionesPorCodigoPostal(String codigoPostal) {
//        return direccionRepository.findByCodigoPostal(codigoPostal);
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public List<Direccion> buscarDireccionesPorCiudadYCodigoPostal(String ciudad, String codigoPostal) {
//        return direccionRepository.findByCiudadAndCodigoPostal(ciudad, codigoPostal);
//    }
//
//    public List<Direccion> buscarDireccionesPorCalle(String calle) {
//        return direccionRepository.findByCalleContainingIgnoreCase(calle);
//    }
//}
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Enums.enumPuestoTrabajador;
//import com.example.demoGestoriaPizzeria.Model.Empleado;
//import com.example.demoGestoriaPizzeria.Model.Pedido;
//import com.example.demoGestoriaPizzeria.Repository.EmpleadoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmpleadoService {
//
//    @Autowired
//    private EmpleadoRepository empleadoRepository;
//
//    public List<Empleado> obtenerTodosLosEmpleados() {
//        return empleadoRepository.findAll();
//    }
//
//    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
//        return empleadoRepository.findById(id);
//    }
//
//    public Empleado guardarEmpleado(Empleado empleado) {
//        return empleadoRepository.save(empleado);
//    }
//
//    public Empleado actualizarEmpleado(Long id, Empleado empleadoActualizado) {
//        return empleadoRepository.findById(id)
//                .map(empleadoExistente -> {
//                    empleadoExistente.setNombre(empleadoActualizado.getNombre());
//                    empleadoExistente.setDocumento(empleadoActualizado.getDocumento());
//                    empleadoExistente.setEmail(empleadoActualizado.getEmail());
//                    empleadoExistente.setTelefono(empleadoActualizado.getTelefono());
//                    empleadoExistente.setDireccion(empleadoActualizado.getDireccion());
//                    empleadoExistente.setSueldo(empleadoActualizado.getSueldo());
//                    empleadoExistente.setActivo(empleadoActualizado.isActivo());
//                    return empleadoRepository.save(empleadoExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
//    }
//
//    public void eliminarEmpleado(Long id) {
//        empleadoRepository.deleteById(id);
//    }
//
//    public void desactivarEmpleado(Long id) {
//        empleadoRepository.findById(id)
//                .ifPresent(empleado -> {
//                    empleado.setActivo(false);
//                    empleadoRepository.save(empleado);
//                });
//    }
//
//    public List<Empleado> obtenerEmpleadosPorPuesto(enumPuestoTrabajador puesto) {
//        return empleadoRepository.findByPuesto(puesto);
//    }
//
//    public List<Empleado> obtenerEmpleadosActivos() {
//        return empleadoRepository.findByActivoTrue();
//    }
//
//    public void asignarPedidoAEmpleado(Long empleadoId, Pedido pedido) {
//        empleadoRepository.findById(empleadoId)
//                .ifPresent(empleado -> {
//                    empleado.asignarPedido(pedido);
//                    empleadoRepository.save(empleado);
//                });
//    }
//
//    public Optional<Empleado> buscarPorDocumento(String documento) {
//        return empleadoRepository.findByDocumento(documento);
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public List<Empleado> obtenerEmpleadosPorPuestoYActivos(enumPuestoTrabajador puesto, boolean activo) {
//        return empleadoRepository.findByPuestoAndActivoTrue(puesto, activo);
//    }
//
//    public List<Empleado> obtenerEmpleadosPorSueldoMinimo(double sueldoMinimo) {
//        return empleadoRepository.findBySueldoGreaterThanEqual(sueldoMinimo);
//    }
//
//    public List<Empleado> obtenerRepartidoresDisponibles(int maxPedidos) {
//        return empleadoRepository.findRepartidoresDisponibles(maxPedidos);
//    }
//}
//
//
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Model.Ingrediente;
//import com.example.demoGestoriaPizzeria.Repository.IngredienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class IngredienteService {
//
//    @Autowired
//    private IngredienteRepository ingredienteRepository;
//
//    public List<Ingrediente> obtenerTodosLosIngredientes() {
//        return ingredienteRepository.findAll();
//    }
//
//    public Optional<Ingrediente> obtenerIngredientePorId(Long id) {
//        return ingredienteRepository.findById(id);
//    }
//
//    public Ingrediente guardarIngrediente(Ingrediente ingrediente) {
//        return ingredienteRepository.save(ingrediente);
//    }
//
//    public Ingrediente actualizarIngrediente(Long id, Ingrediente ingredienteActualizado) {
//        return ingredienteRepository.findById(id)
//                .map(ingredienteExistente -> {
//                    ingredienteExistente.setNombre(ingredienteActualizado.getNombre());
//                    ingredienteExistente.setCantidad(ingredienteActualizado.getCantidad());
//                    ingredienteExistente.setEsVegano(ingredienteActualizado.isEsVegano());
//                    ingredienteExistente.setEsIngredienteSinGluten(ingredienteActualizado.isEsIngredienteSinGluten());
//                    return ingredienteRepository.save(ingredienteExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Ingrediente no encontrado con id: " + id));
//    }
//
//    public void eliminarIngrediente(Long id) {
//        ingredienteRepository.deleteById(id);
//    }
//
//    public List<Ingrediente> obtenerIngredientesSinGluten() {
//        return ingredienteRepository.findByEsIngredienteSinGlutenTrue();
//    }
//
//    public List<Ingrediente> obtenerIngredientesVeganos() {
//        return ingredienteRepository.findByEsVeganoTrue();
//    }
//
//    public void actualizarStockIngrediente(Long id, int cantidad) {
//        ingredienteRepository.findById(id)
//                .ifPresent(ingrediente -> {
//                    ingrediente.setCantidad(cantidad);
//                    ingredienteRepository.save(ingrediente);
//                });
//    }
//
//    public List<Ingrediente> obtenerIngredientesPorNombre(String nombre) {
//        return ingredienteRepository.findByNombreContainingIgnoreCase(nombre);
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public Optional<Ingrediente> buscarIngredientePorNombre(String nombre) {
//        return ingredienteRepository.findByNombre(nombre);
//    }
//
//    public List<Ingrediente> obtenerIngredientesConStock(int cantidadMinima) {
//        return ingredienteRepository.findByCantidadGreaterThan(cantidadMinima);
//    }
//
//    public List<Ingrediente> obtenerIngredientesConPocoStock(int cantidadMaxima) {
//        return ingredienteRepository.findByCantidadLessThanEqual(cantidadMaxima);
//    }
//
//    public List<Ingrediente> obtenerIngredientesAgotados() {
//        return ingredienteRepository.findIngredientesAgotados();
//    }
//}
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Enums.enumEstadoPedido;
//import com.example.demoGestoriaPizzeria.Model.Cliente;
//import com.example.demoGestoriaPizzeria.Model.Empleado;
//import com.example.demoGestoriaPizzeria.Model.Pedido;
//import com.example.demoGestoriaPizzeria.Repository.PedidoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PedidoService {
//
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @Autowired
//    private EmpleadoService empleadoService;
//
//    public List<Pedido> obtenerTodosLosPedidos() {
//        return pedidoRepository.findAll();
//    }
//
//    public Optional<Pedido> obtenerPedidoPorId(Long id) {
//        return pedidoRepository.findById(id);
//    }
//
//    public Pedido guardarPedido(Pedido pedido) {
//        if (pedido.getFechaPedido() == null) {
//            pedido.setFechaPedido(LocalDateTime.now());
//        }
//        if (pedido.getEstado() == null) {
//            pedido.setEstado(enumEstadoPedido.PENDIENTE);
//        }
//        return pedidoRepository.save(pedido);
//    }
//
//    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
//        return pedidoRepository.findById(id)
//                .map(pedidoExistente -> {
//                    pedidoExistente.setCliente(pedidoActualizado.getCliente());
//                    pedidoExistente.setEstado(pedidoActualizado.getEstado());
//                    pedidoExistente.setRepartidor(pedidoActualizado.getRepartidor());
//                    pedidoExistente.setPrecio(pedidoActualizado.getPrecio());
//                    pedidoExistente.setTotal(pedidoActualizado.getTotal());
//                    pedidoExistente.setProductos(pedidoActualizado.getProductos());
//                    return pedidoRepository.save(pedidoExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));
//    }
//
//    public void eliminarPedido(Long id) {
//        pedidoRepository.deleteById(id);
//    }
//
//    public List<Pedido> obtenerPedidosPorEstado(enumEstadoPedido estado) {
//        return pedidoRepository.findByEstado(estado);
//    }
//
//    public Pedido cambiarEstadoPedido(Long id, enumEstadoPedido nuevoEstado) {
//        return pedidoRepository.findById(id)
//                .map(pedido -> {
//                    pedido.setEstado(nuevoEstado);
//                    return pedidoRepository.save(pedido);
//                })
//                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));
//    }
//
//    public Pedido asignarRepartidor(Long pedidoId, Long repartidorId) {
//        Pedido pedido = pedidoRepository.findById(pedidoId)
//                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + pedidoId));
//
//        empleadoService.obtenerEmpleadoPorId(repartidorId)
//                .ifPresent(repartidor -> {
//                    pedido.setRepartidor(repartidor);
//                    repartidor.asignarPedido(pedido);
//                });
//
//        return pedidoRepository.save(pedido);
//    }
//
//    // MÉTODOS CORREGIDOS según el repository
//    public List<Pedido> obtenerPedidosPorCliente(Cliente cliente) {
//        return pedidoRepository.findByCliente(cliente);
//    }
//
//    public List<Pedido> obtenerPedidosPorClienteOrdenados(Cliente cliente) {
//        return pedidoRepository.findByClienteOrderByFechaPedidoDesc(cliente);
//    }
//
//    public List<Pedido> obtenerPedidosPorRepartidor(Empleado repartidor) {
//        return pedidoRepository.findByRepartidor(repartidor);
//    }
//
//    // NUEVOS MÉTODOS basados en el repository
//    public List<Pedido> obtenerPedidosPorRangoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
//        return pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
//    }
//
//    public List<Pedido> obtenerPedidosPorMontoMinimo(Double montoMinimo) {
//        return pedidoRepository.findByTotalGreaterThanEqual(montoMinimo);
//    }
//
//    public List<Pedido> obtenerPedidosPorFechaYEstado(LocalDateTime fecha, enumEstadoPedido estado) {
//        return pedidoRepository.findPedidosPorFechaYEstado(fecha, estado);
//    }
//
//    public Double calcularVentasPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
//        return pedidoRepository.calcularVentasPorPeriodo(fechaInicio, fechaFin);
//    }
//}
//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Enums.enumMassa;
//import com.example.demoGestoriaPizzeria.Enums.enumPizza;
//import com.example.demoGestoriaPizzeria.Model.Pizza;
//import com.example.demoGestoriaPizzeria.Repository.PizzaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PizzaService {
//
//    @Autowired
//    private PizzaRepository pizzaRepository;
//
//    public List<Pizza> obtenerTodasLasPizzas() {
//        return pizzaRepository.findAll();
//    }
//
//    public Optional<Pizza> obtenerPizzaPorId(Long id) {
//        return pizzaRepository.findById(id);
//    }
//
//    public Pizza guardarPizza(Pizza pizza) {
//        return pizzaRepository.save(pizza);
//    }
//
//    public Pizza actualizarPizza(Long id, Pizza pizzaActualizada) {
//        return pizzaRepository.findById(id)
//                .map(pizzaExistente -> {
//                    pizzaExistente.setNombre(pizzaActualizada.getNombre());
//                    pizzaExistente.setPrecio(pizzaActualizada.getPrecio());
//                    pizzaExistente.setCantidad(pizzaActualizada.getCantidad());
//                    pizzaExistente.setDescripcion(pizzaActualizada.getDescripcion());
//                    pizzaExistente.setTipo(pizzaActualizada.getTipo());
//                    pizzaExistente.setTipoMasa(pizzaActualizada.getTipoMasa());
//                    pizzaExistente.setEsSinGluten(pizzaActualizada.isEsSinGluten());
//                    pizzaExistente.setIngredientes(pizzaActualizada.getIngredientes());
//                    return pizzaRepository.save(pizzaExistente);
//                })
//                .orElseThrow(() -> new RuntimeException("Pizza no encontrada con id: " + id));
//    }
//
//    public void eliminarPizza(Long id) {
//        pizzaRepository.deleteById(id);
//    }
//
//    public List<Pizza> buscarPizzasPorTipo(enumPizza tipo) {
//        return pizzaRepository.findByTipo(tipo);
//    }
//
//    public List<Pizza> buscarPizzasPorTipoMasa(enumMassa tipoMasa) {
//        return pizzaRepository.findByTipoMasa(tipoMasa);
//    }
//
//    public List<Pizza> buscarPizzasPorNombre(String nombre) {
//        return pizzaRepository.findByNombreContainingIgnoreCase(nombre);
//    }
//
//    public List<Pizza> buscarPizzasSinGluten() {
//        return pizzaRepository.findByEsSinGlutenTrue();
//    }
//
//    public List<Pizza> buscarPizzasPorPrecioMenorQue(Double precio) {
//        return pizzaRepository.findByPrecioLessThan(precio);
//    }
//}