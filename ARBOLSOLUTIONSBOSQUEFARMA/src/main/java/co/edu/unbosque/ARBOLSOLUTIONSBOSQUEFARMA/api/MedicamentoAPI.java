package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.MedicamentoDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Medicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoAPI {

    @Autowired
    private MedicamentoDAO medicamentoDAO;

    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoDAO.findAll();
    }

    @PostMapping
    public Medicamento createMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoDAO.save(medicamento);
    }

    @GetMapping("/{idMedicamento}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable int idMedicamento) {
        return medicamentoDAO.findById(idMedicamento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idMedicamento}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable int idMedicamento, @RequestBody Medicamento medicamentoDetails) {
        return medicamentoDAO.findById(idMedicamento)
                .map(medicamento -> {
                    medicamento.setNombreMedicamento(medicamentoDetails.getNombreMedicamento());
                    medicamento.setPresentacion(medicamentoDetails.getPresentacion());
                    medicamento.setCosto(medicamentoDetails.getCosto());
                    medicamento.setCantidadDisponible(medicamentoDetails.getCantidadDisponible());
                    return ResponseEntity.ok(medicamentoDAO.save(medicamento));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idMedicamento}")
    public ResponseEntity<Object> deleteMedicamento(@PathVariable int idMedicamento) {
        return medicamentoDAO.findById(idMedicamento)
                .map(medicamento -> {
                    medicamentoDAO.delete(medicamento);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
