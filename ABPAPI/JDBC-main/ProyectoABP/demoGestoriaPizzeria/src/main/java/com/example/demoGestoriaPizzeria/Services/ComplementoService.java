//package com.example.demoGestoriaPizzeria.Services;
//
//import com.example.demoGestoriaPizzeria.Model.Complemento;
//import com.example.demoGestoriaPizzeria.Repository.ComplementoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class ComplementoService {
//
//    private final ComplementoRepository complementoRepository;
//
//    @Autowired
//    public ComplementoService(ComplementoRepository complementoRepository) {
//        this.complementoRepository = complementoRepository;
//    }
//
//    public List<Complemento> obtenerTodosLosComplementos() {
//        return complementoRepository.findAll();
//    }
//
//    public Optional<Complemento> obtenerComplementoPorId(Long id) {
//        return complementoRepository.findById(id);
//    }
//
//    public Complemento crearComplemento(Complemento complemento) {
//        return complementoRepository.save(complemento);
//    }
//
//    public Complemento actualizarComplemento(Long id, Complemento complementoActualizado) {
//        return complementoRepository.findById(id)
//                .map(complementoExistente -> {
//                    complementoExistente.setNombre(complementoActualizado.getNombre());
//                    complementoExistente.setTipo(complementoActualizado.getTipo());
//                    complementoExistente.setDisponible(complementoActualizado.isDisponible());
//                    complementoExistente.setEssinGluten(complementoActualizado.isEssinGluten());
//                    complementoExistente.setPrecio(complementoActualizado.getPrecio());
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
//}

package com.example.demoGestoriaPizzeria.Services;

import com.example.demoGestoriaPizzeria.Model.Complemento;
import com.example.demoGestoriaPizzeria.Repository.ComplementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplementoService {

    @Autowired
    private ComplementoRepository complementoRepository;

    public List<Complemento> obtenerTodosLosComplementos() {
        return complementoRepository.findAll();
    }

    public Optional<Complemento> obtenerComplementoPorId(Long id) {
        return complementoRepository.findById(id);
    }

    public Complemento guardarComplemento(Complemento complemento) {
        return complementoRepository.save(complemento);
    }

    public Complemento actualizarComplemento(Long id, Complemento complementoActualizado) {
        return complementoRepository.findById(id)
                .map(complementoExistente -> {
                    complementoExistente.setNombre(complementoActualizado.getNombre());
                    complementoExistente.setPrecio(complementoActualizado.getPrecio());
                    complementoExistente.setCantidad(complementoActualizado.getCantidad());
                    complementoExistente.setTipo(complementoActualizado.getTipo());
                    complementoExistente.setDisponible(complementoActualizado.isDisponible());
                    complementoExistente.setEssinGluten(complementoActualizado.isEssinGluten());
                    return complementoRepository.save(complementoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Complemento no encontrado con id: " + id));
    }

    public void eliminarComplemento(Long id) {
        complementoRepository.deleteById(id);
    }

    public List<Complemento> obtenerComplementosPorTipo(String tipo) {
        return complementoRepository.findByTipo(tipo);
    }

    public List<Complemento> obtenerComplementosDisponibles() {
        return complementoRepository.findByDisponibleTrue();
    }

    public List<Complemento> obtenerComplementosSinGluten() {
        return complementoRepository.findByEssinGlutenTrue();
    }

    // NUEVOS MÉTODOS basados en el repository
    public List<Complemento> obtenerComplementosPorTipoYDisponibilidad(String tipo, boolean disponible) {
        return complementoRepository.findByTipoAndDisponibleTrue(tipo, disponible);
    }

    public List<Complemento> buscarComplementosPorNombre(String nombre) {
        return complementoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
