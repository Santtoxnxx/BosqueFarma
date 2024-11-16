package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoDAO extends JpaRepository<Turno, Integer> {
    
    Turno findByEstado(String estado);
}