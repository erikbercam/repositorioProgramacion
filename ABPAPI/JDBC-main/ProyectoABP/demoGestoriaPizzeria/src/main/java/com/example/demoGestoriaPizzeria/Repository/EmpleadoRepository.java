package com.example.demoGestoriaPizzeria.Repository;

import com.example.demoGestoriaPizzeria.Enums.enumPuestoTrabajador;
import com.example.demoGestoriaPizzeria.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByPuesto(enumPuestoTrabajador puesto);
    List<Empleado> findByActivoTrue();
    List<Empleado> findByPuestoAndActivoTrue(enumPuestoTrabajador puesto, boolean activo);
    Optional<Empleado> findByDocumento(String documento);
    List<Empleado> findBySueldoGreaterThanEqual(double sueldo);

    @Query("SELECT e FROM Empleado e WHERE e.puesto = 'REPARTIDOR' AND e.activo = true AND SIZE(e.pedidos) < :maxPedidos")
    List<Empleado> findRepartidoresDisponibles(int maxPedidos);
}