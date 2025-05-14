package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
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

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        Producto producto = new Producto("Laptop", "Laptop gaming de alto rendimiento", 1200.00, 10);
        repositorio.insertar(producto);
        producto = new Producto("Monitor", "Monitor 27 pulgadas 4K", 350.50, 15);
        repositorio.insertar(producto);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        repositorio.borrarTodos();
        Producto producto1 = new Producto("Laptop", "Laptop gaming de alto rendimiento", 1200.00, 10);
        Producto producto2 = new Producto("Monitor", "Monitor 27 pulgadas 4K", 350.50, 15);
        repositorio.insertar(producto1);
        repositorio.insertar(producto2);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void borrarProducto() {
        repositorio.borrarTodos();
        Producto producto1 = new Producto("Laptop", "Laptop gaming de alto rendimiento", 1200.00, 10);
        Producto producto2 = new Producto("Monitor", "Monitor 27 pulgadas 4K", 350.50, 15);
        repositorio.insertar(producto1);
        repositorio.insertar(producto2);

        Producto productoABorrar = new Producto("Laptop");
        repositorio.borrar(productoABorrar);

        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());
    }

    @Test
    void buscarUno() {
        repositorio.borrarTodos();
        Producto producto = new Producto("Monitor", "Monitor 27 pulgadas 4K", 350.50, 15);
        repositorio.insertar(producto);

        Producto productoEncontrado = repositorio.buscarUno("Monitor");
        assertNotNull(productoEncontrado);
        assertEquals("Monitor", productoEncontrado.getNombre());
    }
}