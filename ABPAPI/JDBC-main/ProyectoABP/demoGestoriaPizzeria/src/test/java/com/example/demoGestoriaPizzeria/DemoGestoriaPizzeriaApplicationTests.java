package com.example.demoGestoriaPizzeria;

import com.example.demoGestoriaPizzeria.Enums.*;
import com.example.demoGestoriaPizzeria.Model.*;
import com.example.demoGestoriaPizzeria.Repository.*;
import com.example.demoGestoriaPizzeria.Services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DemoGestoriaPizzeriaApplicationTests {

	// =============== MOCKS DE REPOSITORIOS ===============
	@Mock
	private BebidaRepository bebidaRepository;
	@Mock
	private ClienteRepository clienteRepository;
	@Mock
	private ComboRepository comboRepository;
	@Mock
	private ComplementoRepository complementoRepository;
	@Mock
	private DireccionRepository direccionRepository;
	@Mock
	private EmpleadoRepository empleadoRepository;
	@Mock
	private IngredienteRepository ingredienteRepository;
	@Mock
	private PedidoRepository pedidoRepository;
	@Mock
	private PizzaRepository pizzaRepository;
	@Mock
	private ProductoRepository productoRepository;

	// =============== SERVICES A TESTEAR ===============
	@InjectMocks
	private BebidaService bebidaService;
	@InjectMocks
	private ClienteService clienteService;
	@InjectMocks
	private ComboService comboService;
	@InjectMocks
	private ComplementoService complementoService;
	@InjectMocks
	private DireccionService direccionService;
	@InjectMocks
	private EmpleadoService empleadoService;
	@InjectMocks
	private IngredienteService ingredienteService;
	@InjectMocks
	private PedidoService pedidoService;
	@InjectMocks
	private PizzaService pizzaService;

	// =============== DATOS DE PRUEBA ===============
	private Bebida bebida;
	private Cliente cliente;
	private Combo combo;
	private Complemento complemento;
	private Direccion direccion;
	private Empleado empleado;
	private Ingrediente ingrediente;
	private Pedido pedido;
	private Pizza pizza;
	private Producto producto;

	@BeforeEach
	void setUp() {
		// Setup de dirección
		direccion = new Direccion();
		direccion.setId(1L);
		direccion.setCalle("Calle Principal");
		direccion.setNumero("123");
		direccion.setCiudad("Madrid");
		direccion.setCodigoPostal("28001");

		// Setup de bebida
		bebida = new Bebida("Coca Cola", 2.50, TamanoBebida.MEDIANO);
		bebida.setId(1L);
		bebida.setCantidad(50);
		bebida.setDisponible(true);

		// Setup de cliente
		cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNombre("Juan Pérez");
		cliente.setDocumento("12345678A");
		cliente.setEmail("juan@email.com");
		cliente.setTelefono("666123456");
		cliente.setDireccion(direccion);

		// Setup de ingrediente
		ingrediente = new Ingrediente();
		ingrediente.setId(1L);
		ingrediente.setNombre("Queso Mozzarella");
		ingrediente.setCantidad(100);
		ingrediente.setEsVegano(false);
		ingrediente.setEsIngredienteSinGluten(true);

		// Setup de pizza
		pizza = new Pizza();
		pizza.setId(1L);
		pizza.setNombre("Margarita");
		pizza.setPrecio(12.50);
		pizza.setCantidad(20);
		pizza.setDescripcion("Pizza clásica italiana");
		pizza.setTipo(enumPizza.MARGARITA);
		pizza.setTipoMasa(enumMassa.FINA);
		pizza.setEsSinGluten(false);
		pizza.setIngredientes(new HashSet<>(Arrays.asList(ingrediente)));

		// Setup de complemento
		complemento = new Complemento();
		complemento.setId(1L);
		complemento.setNombre("Salsa BBQ");
		complemento.setPrecio(1.50);
		complemento.setCantidad(30);
		complemento.setTipo("SALSA");
		complemento.setDisponible(true);
		complemento.setEssinGluten(true);

		// Setup de empleado
		empleado = new Empleado();
		empleado.setId(1L);
		empleado.setNombre("María García");
		empleado.setDocumento("87654321B");
		empleado.setEmail("maria@pizzeria.com");
		empleado.setTelefono("666987654");
		empleado.setDireccion(direccion);
		empleado.setPuesto(enumPuestoTrabajador.REPARTIDOR);
		empleado.setSueldo(1500.0);
		empleado.setActivo(true);

		// Setup de combo
		combo = new Combo();
		combo.setId(1L);
		combo.setNombre("Combo Familiar");
		combo.setPrecio(25.0);
		combo.setCantidad(10);
		combo.setProductos(Arrays.asList(pizza, bebida));

		// Setup de pedido
		pedido = new Pedido();
		pedido.setIdPedido(1L);
		pedido.setCliente(cliente);
		pedido.setRepartidor(empleado);
		pedido.setEstado(enumEstadoPedido.PENDIENTE);
		pedido.setFechaPedido(LocalDateTime.now());
		pedido.setPrecio(15.0);
		pedido.setTotal(15.0);
		pedido.setProductos(new HashSet<>(Arrays.asList(pizza, bebida)));
	}

	// =============== TESTS DE BEBIDA SERVICE ===============

	@Test
	void testGuardarBebida() {
		when(bebidaRepository.findByNombreAndTamano(anyString(), any(TamanoBebida.class)))
				.thenReturn(Optional.empty());
		when(bebidaRepository.save(any(Bebida.class))).thenReturn(bebida);

		Bebida resultado = bebidaService.guardarBebida(bebida);

		assertNotNull(resultado);
		assertEquals("Coca Cola", resultado.getNombre());
		assertEquals(TamanoBebida.MEDIANO, resultado.getTamano());
		verify(bebidaRepository).save(bebida);
	}

	@Test
	void testGuardarBebidaDuplicada() {
		when(bebidaRepository.findByNombreAndTamano(anyString(), any(TamanoBebida.class)))
				.thenReturn(Optional.of(bebida));

		assertThrows(RuntimeException.class, () -> bebidaService.guardarBebida(bebida));
		verify(bebidaRepository, never()).save(any());
	}

	@Test
	void testObtenerBebidasDisponibles() {
		when(bebidaRepository.findByDisponibleTrue()).thenReturn(Arrays.asList(bebida));

		List<Bebida> resultado = bebidaService.obtenerBebidasDisponibles();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).isDisponible());
		verify(bebidaRepository).findByDisponibleTrue();
	}

	@Test
	void testObtenerBebidasEnStock() {
		when(bebidaRepository.findByDisponibleTrueAndCantidadGreaterThan(0))
				.thenReturn(Arrays.asList(bebida));

		List<Bebida> resultado = bebidaService.obtenerBebidasEnStock();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).getCantidad() > 0);
		verify(bebidaRepository).findByDisponibleTrueAndCantidadGreaterThan(0);
	}

	@Test
	void testHayStockSuficiente() {
		when(bebidaRepository.findById(1L)).thenReturn(Optional.of(bebida));

		boolean resultado = bebidaService.hayStock(1L, 10);

		assertTrue(resultado);
		verify(bebidaRepository).findById(1L);
	}

	@Test
	void testHayStockInsuficiente() {
		when(bebidaRepository.findById(1L)).thenReturn(Optional.of(bebida));

		boolean resultado = bebidaService.hayStock(1L, 100);

		assertFalse(resultado);
		verify(bebidaRepository).findById(1L);
	}

	// =============== TESTS DE CLIENTE SERVICE ===============

	@Test
	void testGuardarCliente() {
		when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

		Cliente resultado = clienteService.guardarCliente(cliente);

		assertNotNull(resultado);
		assertEquals("Juan Pérez", resultado.getNombre());
		assertEquals("12345678A", resultado.getDocumento());
		verify(clienteRepository).save(cliente);
	}

	@Test
	void testBuscarClientePorDocumento() {
		when(clienteRepository.findByDocumento("12345678A")).thenReturn(Optional.of(cliente));

		Optional<Cliente> resultado = clienteService.buscarPorDocumento("12345678A");

		assertTrue(resultado.isPresent());
		assertEquals("12345678A", resultado.get().getDocumento());
		verify(clienteRepository).findByDocumento("12345678A");
	}

	@Test
	void testBuscarClientePorEmail() {
		when(clienteRepository.findByEmail("juan@email.com")).thenReturn(Optional.of(cliente));

		Optional<Cliente> resultado = clienteService.buscarPorEmail("juan@email.com");

		assertTrue(resultado.isPresent());
		assertEquals("juan@email.com", resultado.get().getEmail());
		verify(clienteRepository).findByEmail("juan@email.com");
	}

	@Test
	void testBuscarClientesPorNombre() {
		when(clienteRepository.findByNombreContainingIgnoreCase("juan"))
				.thenReturn(Arrays.asList(cliente));

		List<Cliente> resultado = clienteService.buscarClientesPorNombre("juan");

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).getNombre().toLowerCase().contains("juan"));
		verify(clienteRepository).findByNombreContainingIgnoreCase("juan");
	}

	@Test
	void testActualizarCliente() {
		Cliente clienteActualizado = new Cliente();
		clienteActualizado.setNombre("Juan Carlos Pérez");
		clienteActualizado.setDocumento("12345678A");
		clienteActualizado.setEmail("juan.carlos@email.com");
		clienteActualizado.setTelefono("666123456");
		clienteActualizado.setDireccion(direccion);

		when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
		when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteActualizado);

		Cliente resultado = clienteService.actualizarCliente(1L, clienteActualizado);

		assertNotNull(resultado);
		assertEquals("Juan Carlos Pérez", resultado.getNombre());
		verify(clienteRepository).findById(1L);
		verify(clienteRepository).save(any(Cliente.class));
	}

	// =============== TESTS DE PIZZA SERVICE ===============

	@Test
	void testGuardarPizza() {
		when(pizzaRepository.save(any(Pizza.class))).thenReturn(pizza);

		Pizza resultado = pizzaService.guardarPizza(pizza);

		assertNotNull(resultado);
		assertEquals("Margarita", resultado.getNombre());
		assertEquals(enumPizza.MARGARITA, resultado.getTipo());
		verify(pizzaRepository).save(pizza);
	}

	@Test
	void testBuscarPizzasPorTipo() {
		when(pizzaRepository.findByTipo(enumPizza.MARGARITA)).thenReturn(Arrays.asList(pizza));

		List<Pizza> resultado = pizzaService.buscarPizzasPorTipo(enumPizza.MARGARITA);

		assertEquals(1, resultado.size());
		assertEquals(enumPizza.MARGARITA, resultado.get(0).getTipo());
		verify(pizzaRepository).findByTipo(enumPizza.MARGARITA);
	}

	@Test
	void testBuscarPizzasPorTipoMasa() {
		when(pizzaRepository.findByTipoMasa(enumMassa.FINA)).thenReturn(Arrays.asList(pizza));

		List<Pizza> resultado = pizzaService.buscarPizzasPorTipoMasa(enumMassa.FINA);

		assertEquals(1, resultado.size());
		assertEquals(enumMassa.FINA, resultado.get(0).getTipoMasa());
		verify(pizzaRepository).findByTipoMasa(enumMassa.FINA);
	}

	@Test
	void testBuscarPizzasSinGluten() {
		Pizza pizzaSinGluten = new Pizza();
		pizzaSinGluten.setEsSinGluten(true);
		pizzaSinGluten.setNombre("Margarita Sin Gluten");

		when(pizzaRepository.findByEsSinGlutenTrue()).thenReturn(Arrays.asList(pizzaSinGluten));

		List<Pizza> resultado = pizzaService.buscarPizzasSinGluten();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).isEsSinGluten());
		verify(pizzaRepository).findByEsSinGlutenTrue();
	}

	@Test
	void testBuscarPizzasPorPrecioMenorQue() {
		when(pizzaRepository.findByPrecioLessThan(15.0)).thenReturn(Arrays.asList(pizza));

		List<Pizza> resultado = pizzaService.buscarPizzasPorPrecioMenorQue(15.0);

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).getPrecio() < 15.0);
		verify(pizzaRepository).findByPrecioLessThan(15.0);
	}

	// =============== TESTS DE INGREDIENTE SERVICE ===============

	@Test
	void testGuardarIngrediente() {
		when(ingredienteRepository.save(any(Ingrediente.class))).thenReturn(ingrediente);

		Ingrediente resultado = ingredienteService.guardarIngrediente(ingrediente);

		assertNotNull(resultado);
		assertEquals("Queso Mozzarella", resultado.getNombre());
		assertEquals(100, resultado.getCantidad());
		verify(ingredienteRepository).save(ingrediente);
	}

	@Test
	void testObtenerIngredientesVeganos() {
		Ingrediente ingredienteVegano = new Ingrediente();
		ingredienteVegano.setNombre("Tomate");
		ingredienteVegano.setEsVegano(true);

		when(ingredienteRepository.findByEsVeganoTrue()).thenReturn(Arrays.asList(ingredienteVegano));

		List<Ingrediente> resultado = ingredienteService.obtenerIngredientesVeganos();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).isEsVegano());
		verify(ingredienteRepository).findByEsVeganoTrue();
	}

	@Test
	void testObtenerIngredientesSinGluten() {
		when(ingredienteRepository.findByEsIngredienteSinGlutenTrue()).thenReturn(Arrays.asList(ingrediente));

		List<Ingrediente> resultado = ingredienteService.obtenerIngredientesSinGluten();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).isEsIngredienteSinGluten());
		verify(ingredienteRepository).findByEsIngredienteSinGlutenTrue();
	}

	@Test
	void testObtenerIngredientesConPocoStock() {
		Ingrediente ingredientePocoStock = new Ingrediente();
		ingredientePocoStock.setNombre("Aceitunas");
		ingredientePocoStock.setCantidad(5);

		when(ingredienteRepository.findByCantidadLessThanEqual(10))
				.thenReturn(Arrays.asList(ingredientePocoStock));

		List<Ingrediente> resultado = ingredienteService.obtenerIngredientesConPocoStock(10);

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).getCantidad() <= 10);
		verify(ingredienteRepository).findByCantidadLessThanEqual(10);
	}

	@Test
	void testObtenerIngredientesAgotados() {
		Ingrediente ingredienteAgotado = new Ingrediente();
		ingredienteAgotado.setNombre("Pepperoni");
		ingredienteAgotado.setCantidad(0);

		when(ingredienteRepository.findIngredientesAgotados())
				.thenReturn(Arrays.asList(ingredienteAgotado));

		List<Ingrediente> resultado = ingredienteService.obtenerIngredientesAgotados();

		assertEquals(1, resultado.size());
		assertEquals(0, resultado.get(0).getCantidad());
		verify(ingredienteRepository).findIngredientesAgotados();
	}

	// =============== TESTS DE EMPLEADO SERVICE ===============

	@Test
	void testGuardarEmpleado() {
		when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado);

		Empleado resultado = empleadoService.guardarEmpleado(empleado);

		assertNotNull(resultado);
		assertEquals("María García", resultado.getNombre());
		assertEquals(enumPuestoTrabajador.REPARTIDOR, resultado.getPuesto()); // Ahora funcionará
		verify(empleadoRepository).save(empleado);
	}


	@Test
	void testObtenerEmpleadosPorPuesto() {
		when(empleadoRepository.findByPuesto(enumPuestoTrabajador.REPARTIDOR))
				.thenReturn(Arrays.asList(empleado));

		List<Empleado> resultado = empleadoService.obtenerEmpleadosPorPuesto(enumPuestoTrabajador.REPARTIDOR);

		assertEquals(1, resultado.size());
		assertEquals(enumPuestoTrabajador.REPARTIDOR, resultado.get(0).getPuesto());
		verify(empleadoRepository).findByPuesto(enumPuestoTrabajador.REPARTIDOR);
	}

	@Test
	void testObtenerEmpleadosActivos() {
		when(empleadoRepository.findByActivoTrue()).thenReturn(Arrays.asList(empleado));

		List<Empleado> resultado = empleadoService.obtenerEmpleadosActivos();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).isActivo());
		verify(empleadoRepository).findByActivoTrue();
	}

	@Test
	void testDesactivarEmpleado() {
		when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));
		when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado);

		empleadoService.desactivarEmpleado(1L);

		verify(empleadoRepository).findById(1L);
		verify(empleadoRepository).save(any(Empleado.class));
	}

	@Test
	void testObtenerRepartidoresDisponibles() {
		when(empleadoRepository.findRepartidoresDisponibles(5)).thenReturn(Arrays.asList(empleado));

		List<Empleado> resultado = empleadoService.obtenerRepartidoresDisponibles(5);

		assertEquals(1, resultado.size());
		assertEquals(enumPuestoTrabajador.REPARTIDOR, resultado.get(0).getPuesto());
		verify(empleadoRepository).findRepartidoresDisponibles(5);
	}

	// =============== TESTS DE PEDIDO SERVICE ===============

	@Test
	void testGuardarPedido() {
		Pedido nuevoPedido = new Pedido();
		nuevoPedido.setCliente(cliente);
		nuevoPedido.setProductos(new HashSet<>(Arrays.asList(pizza, bebida)));
		nuevoPedido.setTotal(15.0);

		when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

		Pedido resultado = pedidoService.guardarPedido(nuevoPedido);

		assertNotNull(resultado);
		assertNotNull(resultado.getFechaPedido());
		assertEquals(enumEstadoPedido.PENDIENTE, resultado.getEstado());
		verify(pedidoRepository).save(any(Pedido.class));
	}

	@Test
	void testCambiarEstadoPedido() {
		when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

		Pedido pedidoActualizado = new Pedido();
		pedidoActualizado.setIdPedido(1L);
		pedidoActualizado.setEstado(enumEstadoPedido.EN_PREPARACION);

		when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedidoActualizado);

		Pedido resultado = pedidoService.cambiarEstadoPedido(1L, enumEstadoPedido.EN_PREPARACION);

		assertEquals(enumEstadoPedido.EN_PREPARACION, resultado.getEstado());
		verify(pedidoRepository).findById(1L);
		verify(pedidoRepository).save(any(Pedido.class));
	}

//	@Test
//	void testAsignarRepartidor() {
//		// CORREGIDO: Configurar el mock correctamente
//		when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
//        when(empleadoService.obtenerEmpleadoPorId(1L)).thenReturn(java.util.Optional.of(empleado));
//		when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
//
//		Pedido resultado = pedidoService.asignarRepartidor(1L, 1L);
//
//		assertNotNull(resultado.getRepartidor());
//		assertEquals(empleado.getId(), resultado.getRepartidor().getId());
//		verify(pedidoRepository).findById(1L);
//        verify(empleadoService).obtenerEmpleadoPorId(1L);
//		verify(pedidoRepository).save(any(Pedido.class));
//	}
//

	@Test
	void testObtenerPedidosPorEstado() {
		when(pedidoRepository.findByEstado(enumEstadoPedido.PENDIENTE))
				.thenReturn(Arrays.asList(pedido));

		List<Pedido> resultado = pedidoService.obtenerPedidosPorEstado(enumEstadoPedido.PENDIENTE);

		assertEquals(1, resultado.size());
		assertEquals(enumEstadoPedido.PENDIENTE, resultado.get(0).getEstado());
		verify(pedidoRepository).findByEstado(enumEstadoPedido.PENDIENTE);
	}

//	@Test
//	void testCalcularVentasPorPeriodo() {
//		LocalDateTime inicio = LocalDateTime.now().minusDays(7);
//		LocalDateTime fin = LocalDateTime.now();
//
//		when(pedidoRepository.calcularVentasPorPeriodo(inicio, fin)).thenReturn(1500.0);
//
//		Double resultado = pedidoService.calcularVentasPorPeriodo(inicio, fin);
//
//		assertEquals(1500.0, resultado);
//		verify(pedidoRepository).calcularVentasPorPeriodo(inicio, fin);
//	}

	// =============== TESTS DE COMBO SERVICE ===============

	@Test
	void testGuardarCombo() {
		when(comboRepository.save(any(Combo.class))).thenReturn(combo);

		Combo resultado = comboService.guardarCombo(combo);

		assertNotNull(resultado);
		assertEquals("Combo Familiar", resultado.getNombre());
		assertEquals(25.0, resultado.getPrecio());
		verify(comboRepository).save(combo);
	}

	@Test
	void testAgregarProductoACombo() {
		// CORREGIDO: Crear combo con lista mutable desde el inicio
		Combo comboConListaMutable = new Combo();
		comboConListaMutable.setId(1L);
		comboConListaMutable.setNombre("Combo Familiar");
		comboConListaMutable.setPrecio(25.0);
		comboConListaMutable.setCantidad(10);
		comboConListaMutable.setProductos(new ArrayList<>());

		when(comboRepository.findById(1L)).thenReturn(Optional.of(comboConListaMutable));
		when(productoRepository.findById(1L)).thenReturn(Optional.of(pizza));
		when(comboRepository.save(any(Combo.class))).thenReturn(comboConListaMutable);

		Combo resultado = comboService.agregarProductoACombo(1L, 1L);

		assertNotNull(resultado);
		verify(comboRepository).findById(1L);
		verify(productoRepository).findById(1L);
		verify(comboRepository).save(any(Combo.class));
	}
	@Test
	void testBuscarCombosPorRangoPrecio() {
		when(comboRepository.findByPrecioBetween(20.0, 30.0)).thenReturn(Arrays.asList(combo));

		List<Combo> resultado = comboService.buscarCombosPorRangoPrecio(20.0, 30.0);

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).getPrecio() >= 20.0 && resultado.get(0).getPrecio() <= 30.0);
		verify(comboRepository).findByPrecioBetween(20.0, 30.0);
	}

	// =============== TESTS DE COMPLEMENTO SERVICE ===============

	@Test
	void testGuardarComplemento() {
		when(complementoRepository.save(any(Complemento.class))).thenReturn(complemento);

		Complemento resultado = complementoService.guardarComplemento(complemento);

		assertNotNull(resultado);
		assertEquals("Salsa BBQ", resultado.getNombre());
		assertEquals("SALSA", resultado.getTipo());
		verify(complementoRepository).save(complemento);
	}

	@Test
	void testObtenerComplementosPorTipo() {
		when(complementoRepository.findByTipo("SALSA")).thenReturn(Arrays.asList(complemento));

		List<Complemento> resultado = complementoService.obtenerComplementosPorTipo("SALSA");

		assertEquals(1, resultado.size());
		assertEquals("SALSA", resultado.get(0).getTipo());
		verify(complementoRepository).findByTipo("SALSA");
	}

	@Test
	void testObtenerComplementosDisponibles() {
		when(complementoRepository.findByDisponibleTrue()).thenReturn(Arrays.asList(complemento));

		List<Complemento> resultado = complementoService.obtenerComplementosDisponibles();

		assertEquals(1, resultado.size());
		assertTrue(resultado.get(0).isDisponible());
		verify(complementoRepository).findByDisponibleTrue();
	}

	// =============== TESTS DE DIRECCIÓN SERVICE ===============

	@Test
	void testGuardarDireccion() {
		when(direccionRepository.save(any(Direccion.class))).thenReturn(direccion);

		Direccion resultado = direccionService.guardarDireccion(direccion);

		assertNotNull(resultado);
		assertEquals("Calle Principal", resultado.getCalle());
		assertEquals("Madrid", resultado.getCiudad());
		verify(direccionRepository).save(direccion);
	}

	@Test
	void testBuscarDireccionesPorCiudad() {
		when(direccionRepository.findByCiudad("Madrid")).thenReturn(Arrays.asList(direccion));

		List<Direccion> resultado = direccionService.buscarDireccionesPorCiudad("Madrid");

		assertEquals(1, resultado.size());
		assertEquals("Madrid", resultado.get(0).getCiudad());
		verify(direccionRepository).findByCiudad("Madrid");
	}

	@Test
	void testBuscarDireccionesPorCodigoPostal() {
		when(direccionRepository.findByCodigoPostal("28001")).thenReturn(Arrays.asList(direccion));

		List<Direccion> resultado = direccionService.buscarDireccionesPorCodigoPostal("28001");

		assertEquals(1, resultado.size());
		assertEquals("28001", resultado.get(0).getCodigoPostal());
		verify(direccionRepository).findByCodigoPostal("28001");
	}

	// =============== TESTS DE CASOS EDGE Y EXCEPCIONES ===============

	@Test
	void testBuscarPedidoInexistente() {
		when(pedidoRepository.findById(999L)).thenReturn(Optional.empty());

		assertThrows(RuntimeException.class, () -> {
			pedidoService.actualizarPedido(999L, new Pedido());
		});

		verify(pedidoRepository).findById(999L);
	}

	@Test
	void testActualizarPizzaInexistente() {
		when(pizzaRepository.findById(999L)).thenReturn(Optional.empty());

		assertThrows(RuntimeException.class, () -> {
			pizzaService.actualizarPizza(999L, new Pizza());
		});

		verify(pizzaRepository).findById(999L);
	}

	@Test
	void testEliminarBebidaInexistente() {
		when(bebidaRepository.existsById(999L)).thenReturn(false);

		assertThrows(RuntimeException.class, () -> {
			bebidaService.eliminarBebida(999L);
		});

		verify(bebidaRepository).existsById(999L);
		verify(bebidaRepository, never()).deleteById(anyLong());
	}
}