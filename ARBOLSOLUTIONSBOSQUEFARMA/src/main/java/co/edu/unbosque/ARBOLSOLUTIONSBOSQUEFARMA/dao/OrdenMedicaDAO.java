package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.OrdenMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenMedicaDAO extends JpaRepository<OrdenMedica, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
