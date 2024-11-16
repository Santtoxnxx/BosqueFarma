package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoDAO extends JpaRepository<Medicamento, Integer> {
    Medicamento findByNombreMedicamento(String nombreMedicamento);
}