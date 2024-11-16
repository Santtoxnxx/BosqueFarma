package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.FuncionarioDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosAPI {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    // Obtener todos los funcionarios
    @GetMapping
    public List<Funcionarios> getAllFuncionarios() {
        return funcionarioDAO.findAll();
    }

    // Crear un nuevo funcionario
    @PostMapping
    public Funcionarios createFuncionario(@RequestBody Funcionarios funcionario) {
        return funcionarioDAO.save(funcionario);
    }

    // Obtener un funcionario por cédula
    @GetMapping("/{cedula}")
    public ResponseEntity<Funcionarios> getFuncionarioById(@PathVariable Long cedula) {
        return funcionarioDAO.findById(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un funcionario
    @PutMapping("/{cedula}")
    public ResponseEntity<Funcionarios> updateFuncionario(@PathVariable Long cedula, @RequestBody Funcionarios funcionarioDetails) {
        return funcionarioDAO.findById(cedula)
                .map(funcionario -> {
                    funcionario.setNombre(funcionarioDetails.getNombre());
                    funcionario.setClave(funcionarioDetails.getClave());
                    return ResponseEntity.ok(funcionarioDAO.save(funcionario));
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un funcionario
    @DeleteMapping("/{cedula}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable Long cedula) {
        return funcionarioDAO.findById(cedula)
                .map(funcionario -> {
                    funcionarioDAO.delete(funcionario);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}