package com.example.demoGestoriaPizzeria.Repository;

import com.example.demoGestoriaPizzeria.Model.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento, Long> {
    List<Complemento> findByTipo(String tipo);
    List<Complemento> findByDisponibleTrue();
    List<Complemento> findByEssinGlutenTrue();
    List<Complemento> findByTipoAndDisponibleTrue(String tipo, boolean disponible);
    List<Complemento> findByNombreContainingIgnoreCase(String nombre);
}