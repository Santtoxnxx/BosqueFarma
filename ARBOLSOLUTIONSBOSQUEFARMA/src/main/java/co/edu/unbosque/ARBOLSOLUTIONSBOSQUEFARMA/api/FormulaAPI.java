package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.FormulaDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formulas")
public class FormulaAPI {

    @Autowired
    private FormulaDAO formulaDAO;

    @GetMapping
    public List<Formula> getAllFormulas() {
        return formulaDAO.findAll();
    }

    @PostMapping
    public Formula createFormula(@RequestBody Formula formula) {
        return formulaDAO.save(formula);
    }

    @GetMapping("/{idFormula}")
    public ResponseEntity<Formula> getFormulaById(@PathVariable int idFormula) {
        return formulaDAO.findById(idFormula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idFormula}")
    public ResponseEntity<Formula> updateFormula(@PathVariable int idFormula, @RequestBody Formula formulaDetails) {
        return formulaDAO.findById(idFormula)
                .map(formula -> {
                    formula.setMedicamento(formulaDetails.getMedicamento());
                    formula.setCantidad(formulaDetails.getCantidad());
                    return ResponseEntity.ok(formulaDAO.save(formula));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idFormula}")
    public ResponseEntity<Object> deleteFormula(@PathVariable int idFormula) {
        return formulaDAO.findById(idFormula)
                .map(formula -> {
                    formulaDAO.delete(formula);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}