package monlau.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import monlau.model.Producto;

public class ProductoDAOImpl implements ProductoDAO {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/inventario?useSSL=false";
    static final String DB_USR = "root";
    static final String DB_PWD = "";

    private void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: failed to load MySQL JDBC Driver");
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            String sql = "INSERT INTO producto (id, nombre, precio) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.executeUpdate();
            System.out.println("Producto insertado en la base de datos.");
        } catch (SQLException ex) {
            throw new RuntimeException("Error al insertar producto", ex);
        } finally {
            closeResources(conn, ps, null);
        }
    }

    @Override
    public void update(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            String sql = "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No se encontró producto con ID: " + producto.getId());
            } else {
                System.out.println("Producto actualizado correctamente.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al actualizar producto", ex);
        } finally {
            closeResources(conn, ps, null);
        }
    }

    @Override
    public void delete(Producto producto) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            String sql = "DELETE FROM producto WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, producto.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No se encontró producto con ID: " + producto.getId());
            } else {
                System.out.println("Producto eliminado correctamente.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al eliminar producto", ex);
        } finally {
            closeResources(conn, ps, null);
        }
    }

    @Override
    public Producto read(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto prod = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            String sql = "SELECT * FROM producto WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                prod = new Producto(id, rs.getString("nombre"), rs.getDouble("precio"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al leer producto", ex);
        } finally {
            closeResources(conn, ps, rs);
        }
        return prod;
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar recursos");
            ex.printStackTrace();
        }
    }
}