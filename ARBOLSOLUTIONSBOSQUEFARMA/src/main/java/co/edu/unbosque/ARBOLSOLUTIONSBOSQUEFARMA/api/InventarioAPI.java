package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.InventarioDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioAPI {

    @Autowired
    private InventarioDAO inventarioDAO;

    // Obtener todos los registros del inventario
    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioDAO.findAll();
    }

    // Crear un nuevo registro en el inventario
    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario) {
        return inventarioDAO.save(inventario);
    }

    // Obtener un registro por ID
    @GetMapping("/{idInventario}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable int idInventario) {
        return inventarioDAO.findById(idInventario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un registro del inventario
    @PutMapping("/{idInventario}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable int idInventario, @RequestBody Inventario inventarioDetails) {
        return inventarioDAO.findById(idInventario)
                .map(inventario -> {
                    inventario.setMedicamento(inventarioDetails.getMedicamento());
                    inventario.setCantidad(inventarioDetails.getCantidad());
                    inventario.setTipoMovimiento(inventarioDetails.getTipoMovimiento());
                    inventarioDAO.save(inventario);
                    return ResponseEntity.ok(inventario);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un registro del inventario
    @DeleteMapping("/{idInventario}")
    public ResponseEntity<Object> deleteInventario(@PathVariable int idInventario) {
        return inventarioDAO.findById(idInventario)
                .map(inventario -> {
                    inventarioDAO.delete(inventario);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}