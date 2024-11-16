package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.api;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao.TurnoDAO;
import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoAPI {

    @Autowired
    private TurnoDAO turnoDAO;

    // Obtener todos los turnos
    @GetMapping
    public List<Turno> getAllTurnos() {
        return turnoDAO.findAll();
    }

    // Crear un nuevo turno
    @PostMapping
    public Turno createTurno(@RequestBody Turno turno) {
        return turnoDAO.save(turno);
    }

    // Obtener un turno por ID
    @GetMapping("/{idTurno}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable int idTurno) {
        return turnoDAO.findById(idTurno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un turno
    @PutMapping("/{idTurno}")
    public ResponseEntity<Turno> updateTurno(@PathVariable int idTurno, @RequestBody Turno turnoDetails) {
        return turnoDAO.findById(idTurno)
                .map(turno -> {
                    turno.setNumTurno(turnoDetails.getNumTurno());
                    turno.setCaja(turnoDetails.getCaja());
                    turno.setDocPaciente(turnoDetails.getDocPaciente());
                    turno.setEstado(turnoDetails.getEstado());
                    turnoDAO.save(turno);
                    return ResponseEntity.ok(turno);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un turno
    @DeleteMapping("/{idTurno}")
    public ResponseEntity<Object> deleteTurno(@PathVariable int idTurno) {
        return turnoDAO.findById(idTurno)
                .map(turno -> {
                    turnoDAO.delete(turno);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}