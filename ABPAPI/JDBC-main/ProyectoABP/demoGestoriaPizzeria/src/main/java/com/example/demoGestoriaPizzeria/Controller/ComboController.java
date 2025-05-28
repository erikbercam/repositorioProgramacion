package com.example.demoGestoriaPizzeria.Controller;

import com.example.demoGestoriaPizzeria.Model.Combo;
import com.example.demoGestoriaPizzeria.Services.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/combos")
@CrossOrigin(origins = "*")
public class ComboController {

    @Autowired
    private ComboService comboService;

    @GetMapping
    public ResponseEntity<List<Combo>> obtenerTodosLosCombos() {
        List<Combo> combos = comboService.obtenerTodosLosCombos();
        return ResponseEntity.ok(combos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combo> obtenerComboPorId(@PathVariable Long id) {
        Optional<Combo> combo = comboService.obtenerComboPorId(id);
        return combo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Combo> crearCombo(@RequestBody Combo combo) {
        Combo nuevoCombo = comboService.guardarCombo(combo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCombo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combo> actualizarCombo(@PathVariable Long id, @RequestBody Combo combo) {
        try {
            Combo comboActualizado = comboService.actualizarCombo(id, combo);
            return ResponseEntity.ok(comboActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCombo(@PathVariable Long id) {
        comboService.eliminarCombo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{comboId}/productos/{productoId}")
    public ResponseEntity<Combo> agregarProductoACombo(@PathVariable Long comboId, @PathVariable Long productoId) {
        try {
            Combo combo = comboService.agregarProductoACombo(comboId, productoId);
            return ResponseEntity.ok(combo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{comboId}/productos/{productoId}")
    public ResponseEntity<Combo> quitarProductoDeCombo(@PathVariable Long comboId, @PathVariable Long productoId) {
        try {
            Combo combo = comboService.quitarProductoDeCombo(comboId, productoId);
            return ResponseEntity.ok(combo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Combo>> buscarCombosPorNombre(@RequestParam String nombre) {
        List<Combo> combos = comboService.buscarCombosPorNombre(nombre);
        return ResponseEntity.ok(combos);
    }

    @GetMapping("/precio")
    public ResponseEntity<List<Combo>> buscarCombosPorRangoPrecio(@RequestParam double min, @RequestParam double max) {
        List<Combo> combos = comboService.buscarCombosPorRangoPrecio(min, max);
        return ResponseEntity.ok(combos);
    }

    @GetMapping("/minimos-productos")
    public ResponseEntity<List<Combo>> buscarCombosConMinProductos(@RequestParam int minProductos) {
        List<Combo> combos = comboService.buscarCombosConMinProductos(minProductos);
        return ResponseEntity.ok(combos);
    }
}
