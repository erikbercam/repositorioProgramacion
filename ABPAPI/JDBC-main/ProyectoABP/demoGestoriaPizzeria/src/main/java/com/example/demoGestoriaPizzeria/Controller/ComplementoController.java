//package com.example.demoGestoriaPizzeria.Controller;

//import com.example.demoGestoriaPizzeria.Model.Complemento;
//import com.example.demoGestoriaPizzeria.Services.ComplementoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/complementos")
//public class ComplementoController {
//
//    private final ComplementoService complementoService;
//
//    @Autowired
//    public ComplementoController(ComplementoService complementoService) {
//        this.complementoService = complementoService;
//    }
//
//    @GetMapping
//    public List<Complemento> obtenerTodosLosComplementos() {
//        return complementoService.obtenerTodosLosComplementos();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Complemento> obtenerComplementoPorId(@PathVariable Long id) {
//        return complementoService.obtenerComplementoPorId(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Complemento> crearComplemento(@RequestBody Complemento complemento) {
//        Complemento nuevoComplemento = complementoService.crearComplemento(complemento);
//        return ResponseEntity.ok(nuevoComplemento);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Complemento> actualizarComplemento(
//            @PathVariable Long id,
//            @RequestBody Complemento complementoActualizado) {
//        try {
//            Complemento complemento = complementoService.actualizarComplemento(id, complementoActualizado);
//            return ResponseEntity.ok(complemento);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarComplemento(@PathVariable Long id) {
//        try {
//            complementoService.eliminarComplemento(id);
//            return ResponseEntity.noContent().build(); // 204 No Content (éxito)
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build(); // 404 Not Found (si no existe)
//        }
//    }
//}


package com.example.demoGestoriaPizzeria.Controller;

import com.example.demoGestoriaPizzeria.Model.Complemento;
import com.example.demoGestoriaPizzeria.Services.ComplementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/complementos")
@CrossOrigin(origins = "*")
public class ComplementoController {

    @Autowired
    private ComplementoService complementoService;

    @GetMapping
    public ResponseEntity<List<Complemento>> obtenerTodosLosComplementos() {
        List<Complemento> complementos = complementoService.obtenerTodosLosComplementos();
        return ResponseEntity.ok(complementos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complemento> obtenerComplementoPorId(@PathVariable Long id) {
        Optional<Complemento> complemento = complementoService.obtenerComplementoPorId(id);
        return complemento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Complemento> crearComplemento(@RequestBody Complemento complemento) {
        Complemento nuevoComplemento = complementoService.guardarComplemento(complemento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComplemento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Complemento> actualizarComplemento(@PathVariable Long id, @RequestBody Complemento complemento) {
        try {
            Complemento complementoActualizado = complementoService.actualizarComplemento(id, complemento);
            return ResponseEntity.ok(complementoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComplemento(@PathVariable Long id) {
        complementoService.eliminarComplemento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Complemento>> obtenerComplementosPorTipo(@PathVariable String tipo) {
        List<Complemento> complementos = complementoService.obtenerComplementosPorTipo(tipo);
        return ResponseEntity.ok(complementos);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Complemento>> obtenerComplementosDisponibles() {
        List<Complemento> complementos = complementoService.obtenerComplementosDisponibles();
        return ResponseEntity.ok(complementos);
    }

    @GetMapping("/sin-gluten")
    public ResponseEntity<List<Complemento>> obtenerComplementosSinGluten() {
        List<Complemento> complementos = complementoService.obtenerComplementosSinGluten();
        return ResponseEntity.ok(complementos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Complemento>> buscarComplementosPorNombre(@RequestParam String nombre) {
        List<Complemento> complementos = complementoService.buscarComplementosPorNombre(nombre);
        return ResponseEntity.ok(complementos);
    }
}