package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.OrdenMedicaDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.OrdenMedica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenesMedicas")
public class OrdenMedicaAPI {

    @Autowired
    private OrdenMedicaDAO ordenMedicaDAO;

    @GetMapping
    public List<OrdenMedica> getAllOrdenesMedicas() {
        return ordenMedicaDAO.findAll();
    }

    @PostMapping
    public OrdenMedica createOrdenMedica(@RequestBody OrdenMedica ordenMedica) {
        return ordenMedicaDAO.save(ordenMedica);
    }

    @GetMapping("/{idOrdenMedica}")
    public ResponseEntity<OrdenMedica> getOrdenMedicaById(@PathVariable Long idOrdenMedica) {
        return ordenMedicaDAO.findById(idOrdenMedica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idOrdenMedica}")
    public ResponseEntity<OrdenMedica> updateOrdenMedica(@PathVariable Long idOrdenMedica, @RequestBody OrdenMedica ordenMedicaDetails) {
        return ordenMedicaDAO.findById(idOrdenMedica)
                .map(ordenMedica -> {
                    ordenMedica.setIdEntidadSalud(ordenMedicaDetails.getIdEntidadSalud());
                    ordenMedica.setNombreEntidadSalud(ordenMedicaDetails.getNombreEntidadSalud());
                    ordenMedica.setDocPaciente(ordenMedicaDetails.getDocPaciente());
                    ordenMedica.setFormula(ordenMedicaDetails.getFormula());
                    return ResponseEntity.ok(ordenMedicaDAO.save(ordenMedica));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idOrdenMedica}")
    public ResponseEntity<Object> deleteOrdenMedica(@PathVariable Long idOrdenMedica) {
        return ordenMedicaDAO.findById(idOrdenMedica)
                .map(ordenMedica -> {
                    ordenMedicaDAO.delete(ordenMedica);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
