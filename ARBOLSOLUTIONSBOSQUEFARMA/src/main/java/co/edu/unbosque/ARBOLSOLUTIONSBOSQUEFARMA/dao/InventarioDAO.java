package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.dao;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.model.Inventario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioDAO extends JpaRepository<Inventario, Integer> {

	List<Inventario> findByTipoMovimiento(String tipoMovimiento);
}