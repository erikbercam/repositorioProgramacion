package org.example.demojdbc.repository;

import java.util.List;

import org.example.demojdbc.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductoRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertar(Producto producto) {
        jdbcTemplate.update("INSERT INTO Producto (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)",
                producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getStock());
    }

    public List<Producto> buscarTodos() {
        return jdbcTemplate.query("SELECT * FROM Producto", new ProductoMapper());
    }

    public Producto buscarPorId(int id) {
        List<Producto> resultados = jdbcTemplate.query("SELECT * FROM Producto WHERE id = ?", new ProductoMapper(), id);
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public Producto buscarPorNombre(String nombre) {
        List<Producto> resultados = jdbcTemplate.query("SELECT * FROM Producto WHERE nombre = ?", new ProductoMapper(), nombre);
        if (resultados.isEmpty()) {
            System.out.println("No se encontró ningún producto con nombre: " + nombre);
            return null;
        } else {
            System.out.println("Producto encontrado: " + resultados.get(0).getNombre());
            return resultados.get(0);
        }
    }


    public Producto buscarUno(String nombre) {
        return buscarPorNombre(nombre);
    }

    @Transactional
    public void actualizar(Producto producto) {
        jdbcTemplate.update("UPDATE Producto SET nombre = ?, descripcion = ?, precio = ?, stock = ? WHERE id = ?",
                producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getStock(), producto.getId());
    }

    @Transactional
    public void borrar(int id) {
        jdbcTemplate.update("DELETE FROM Producto WHERE id = ?", id);
    }


    @Transactional
    public void borrar(Producto producto) {
        borrarPorNombre(producto.getNombre());
    }

    @Transactional
    public void borrarPorNombre(String nombre) {
        jdbcTemplate.update("DELETE FROM Producto WHERE nombre = ?", nombre);
    }

    @Transactional
    public void borrarTodos() {
        jdbcTemplate.update("DELETE FROM Producto");
    }
}