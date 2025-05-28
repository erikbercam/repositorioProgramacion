package com.example.demoGestoriaPizzeria.Repository;

import com.example.demoGestoriaPizzeria.Model.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
    List<Combo> findByNombreContainingIgnoreCase(String nombre);
    List<Combo> findByPrecioBetween(double precioMin, double precioMax);

    @Query("SELECT c FROM Combo c WHERE SIZE(c.productos) >= :minProductos")
    List<Combo> findCombosConMinProductos(int minProductos);


}