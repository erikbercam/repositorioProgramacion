package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql({"/schema.sql"})
class DemoJdbcApplicationTests {

    @Autowired
    ProductoRepository repositorio;

    @BeforeEach
    void setUp() {
        // Limpiar base de datos antes de cada test
        repositorio.borrarTodos();
    }

    @Test
    void borrarTodos() {
        // Insertar datos para luego borrarlos
        repositorio.insertar(new Producto("Test", "Test descripción", 100, 5));

        // Verificar que se haya insertado correctamente
        List<Producto> listaAntes = repositorio.buscarTodos();
        assertEquals(1, listaAntes.size());

        // Borrar todos
        repositorio.borrarTodos();

        // Verificar que se hayan borrado
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        Producto producto = new Producto("Laptop", "Laptop gaming", 120, 10);
        repositorio.insertar(producto);
        producto = new Producto("Monitor", "Monitor 4K", 150.50, 20);
        repositorio.insertar(producto);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        // Insertar datos para poder buscarlos
        repositorio.insertar(new Producto("Laptop", "Laptop gaming", 120, 10));
        repositorio.insertar(new Producto("Monitor", "Monitor 4K", 150.50, 20));

        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void borrarProducto() {
        // Insertar un producto para luego borrarlo
        repositorio.insertar(new Producto("Laptop", "Laptop gaming", 120, 10));
        repositorio.insertar(new Producto("Monitor", "Monitor 4K", 150.50, 20));

        // Primero buscamos el producto por nombre
        Producto producto = repositorio.buscarPorNombre("Laptop");
        assertNotNull(producto, "El producto debería existir antes de borrarlo");

        // Luego lo borramos por ID
        repositorio.borrar(producto.getId());
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());
    }

    @Test
    void buscarUno() {
        // Insertar un producto para luego buscarlo
        repositorio.insertar(new Producto("Monitor", "Monitor 4K", 150.50, 20));

        Producto producto = repositorio.buscarPorNombre("Monitor");
        assertNotNull(producto, "El producto debería existir");
        assertEquals("Monitor", producto.getNombre());
    }
}